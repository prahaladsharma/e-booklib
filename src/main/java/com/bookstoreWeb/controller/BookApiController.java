package com.bookstoreWeb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookstoreWeb.model.AddBookModel;
import com.bookstoreWeb.model.BookIssueModel;
import com.bookstoreWeb.model.Employee;
import com.bookstoreWeb.model.LoginModelResponse;
import com.bookstoreWeb.model.LoginRequest;
import com.bookstoreWeb.model.SignUpModel;
import com.bookstoreWeb.model.UploadFile;
import com.bookstoreWeb.repository.AddBookRepository;
import com.bookstoreWeb.repository.BookIssueRepository;
import com.bookstoreWeb.repository.FileUploadRepository;
import com.bookstoreWeb.repository.LoginRepository;
import com.bookstoreWeb.repository.SignUpRepository;
import com.bookstoreWeb.utility.ColourValidator;
import com.bookstoreWeb.utility.ResourceNotFound;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class BookApiController {

		
	@Autowired
	SignUpRepository signUpRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	AddBookRepository addBookRepository;
	
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	private ArrayList<SignUpModel> loginResponseList;
	private ArrayList<BookIssueModel> bookIssueModel;
	private ArrayList<SignUpModel> studentInfoList;
	private ArrayList<UploadFile> uploadFileList;
	List<AddBookModel> bookList;
	
	@GetMapping("/bookLibrary")
	public String doIndex() {
		return "index";
	}
	
	@GetMapping("/register")
	public String doRegister() {
		return "register";
	}
	
	
	//User login controller
	@RequestMapping(value="/dashboard", method = RequestMethod.POST)
	public String doLogin(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpSession httpSession) {
		
		loginResponseList = new ArrayList<>();
		LoginModelResponse loginResponse = new LoginModelResponse();
		loginResponse.setData(loginRepository.getLoginResponse(email, password));
		
		loginResponseList.addAll(loginRepository.getLoginResponse(email, password));
			
		if(loginResponse.getData().isEmpty()) {
			return "index";
		} else {			
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("id", loginResponse.getData().get(0).getId());
			
			return "dashboard";
		}		
	}
	
	
	// User register controller
	@PostMapping("/addRegister")
	public String registerEmp(@ModelAttribute("reg") SignUpModel registerDao) {
		
		if(registerDao !=null) {
			signUpRepository.save(registerDao);
		} else {
			System.out.println("Null");
		}
		
		return "redirect:/bookLibrary";
	}
	
	
	
	/**
	 * Front-End
	 * URL:- http://localhost:8080/getAllBooks
	 * @param model
	 * @return
	 * It will get all list of book 
	 */
	@RequestMapping(value="/getAllBooks", method = RequestMethod.GET)
	public String getAllBooks(@ModelAttribute ("models") ModelMap model) {
		bookList = (List<AddBookModel>) addBookRepository.findAll();
		model.addAttribute("allBooks", bookList);	
		return "allBook";
	}
	
	
	//User logout controller
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		return "redirect:/bookLibrary";
	}
	

	//Book issue form controller
	//bookissue is an UI, that show GUI for issue book
	@RequestMapping(value = "/bookissue",  method = RequestMethod.GET)
	public ModelAndView bookIssueForm() {
		BookIssueModel employee = new BookIssueModel();
 
		// Add the command object to the modelview
		ModelAndView mv = new ModelAndView("bookissue");
		mv.addObject("employee", employee);
 
		//Add dynamic data to Departments
		bookList = (List<AddBookModel>) addBookRepository.findAll();		
		//System.out.println("bookList" + bookList);
		
		mv.addObject("bookList", bookList);
 
		
		return mv;
	}
 
	
	// User Book issue controller
	// User can issue book here
	@RequestMapping(method = RequestMethod.POST)
	public String submitBookIssueForm(Model model, BookIssueModel bookIssueModel, BindingResult result, HttpSession httpSession) {
		model.addAttribute("employee", bookIssueModel);		
		
		BookIssueModel daoBookObj = new BookIssueModel(bookIssueModel.getBookName(),((int) bookIssueModel.getId()) , ((Long) httpSession.getAttribute("id")).intValue() /*(int)httpSession.getAttribute("id")*/ , bookIssueModel.getBookIssueDate(), bookIssueModel.getBookSubmitDate());
		bookIssueRepository.save(daoBookObj);
		
		return "dashboard";
	}
	
	
	//User can see or purchase available e-book
	@RequestMapping(value="/getEBooks", method = RequestMethod.GET)
	public String getAllAvailableEBook(@ModelAttribute ("models") ModelMap model) {
		
		uploadFileList = new ArrayList<>();
		uploadFileList = (ArrayList<UploadFile>) fileUploadRepository.findAll();
		model.addAttribute("eBooksList", uploadFileList);
		return "ebooks";
	
	}
	
	
	
	
    ////******************************************************************************************************************************////	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////    ADMIN WORK    /////////////////////////////////////////////////////////////////	
	////******************************************************************************************************************************////
	//Admin Work for add book
	//http://localhost:8080/bookList
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String redirectAdmin() {		
		return "admin";
	}
	
	@RequestMapping(value="/bookList", method = RequestMethod.GET)
	public String init(@ModelAttribute ("models") ModelMap model) {
		bookList = (List<AddBookModel>) addBookRepository.findAll();
		model.addAttribute("bookList", bookList);	
		return "books";
	}
	
	@PostMapping(value = "/addBook")
	public String addBook(@ModelAttribute("emp") AddBookModel emp) {
		if (emp != null) {
			addBookRepository.save(emp);
		  } else {
			  System.out.println("Empty List");
		  }
		
	  return "redirect:/bookList";
	}
	
	/* It will provide list of issued book with user details */
	@RequestMapping(value = "/listofissuebook", method = RequestMethod.GET)
	public String getListOfIssueBook(@ModelAttribute("models") ModelMap model) {
		bookIssueModel = (ArrayList<BookIssueModel>) bookIssueRepository.findAll();
		
		System.out.println("bookIssueModel " + bookIssueModel.toString());
		
		model.addAttribute("listofissuebook", bookIssueModel);
		return "listofissuebook";
	}
	
	
	@RequestMapping(value="/studentinfo", method = RequestMethod.GET)
	public String getStudentList(@ModelAttribute ("models") ModelMap model) {
		studentInfoList = (ArrayList<SignUpModel>) signUpRepository.findAll();
		model.addAttribute("studentInfoList", studentInfoList);	
		
		
		return "studentinfo";
	}
	
	
	@RequestMapping(value = "/adminbookupdate/{id}")
	public String findBookById(@ModelAttribute ("models") ModelMap model, @PathVariable("id") Long id)	throws IOException {

		 addBookRepository.findById(id);
		 
		 bookList = new ArrayList<>();
		 
		 AddBookModel book = addBookRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Books", "id", id));
		 bookList.add(book);
		 
		model.addAttribute("bookListUpdate", bookList);

		return "adminbookupdate";
	}
	
	/* It update record for the given id in URL and redirects to /bookList */ 
	@PostMapping(value = "/bookUpdate")
	public String updateBook(@ModelAttribute("bookUpdates") AddBookModel updateBookModel) {
	
		/*if(updateBookModel != null) {
			addBookRepository.save(updateBookModel);
		} else {
			System.out.println("FAIL");
		}*/
		
		return "redirect:/bookList";
	}

	
	/* It deletes record for the given id in URL and redirects to /bookList */    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable long id){    
    	 addBookRepository.deleteById(id);
        return "redirect:/bookList";    
    } 
    
    /**
     * Send mail
     * @param id
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    @RequestMapping(value = "/sendemail/{id}", method = RequestMethod.GET)
    public String sendEmail(@PathVariable long id) throws AddressException, MessagingException, IOException {
    	
    	SignUpModel signUpObj =  signUpRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Books", "id", id));
    	
    	sendmail(signUpObj.getEmail().toString());
       return "redirect:/listofissuebook";
    }  
    
    
    /*
     * By using this method admin can send mail
     */
    private void sendmail(String recevierEmail) throws AddressException, MessagingException, IOException {
    	   Properties props = new Properties();
    	   props.put("mail.smtp.auth", "true");
    	   props.put("mail.smtp.starttls.enable", "true");
    	   props.put("mail.smtp.host", "smtp.googlemail.com");
    	   props.put("mail.smtp.port", "587");
    	   
    	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    	      protected PasswordAuthentication getPasswordAuthentication() {
    	         return new PasswordAuthentication("teamjpr.ds@gmail.com", "dsandroid");
    	      }
    	   });
    	   Message msg = new MimeMessage(session);
    	   msg.setFrom(new InternetAddress("teamjpr.ds@gmail.com", false));

    	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recevierEmail));
    	   msg.setSubject("Submit Book");
    	   msg.setContent("E-BookLibrary email", "text/html");
    	   msg.setSentDate(new Date());

    	   MimeBodyPart messageBodyPart = new MimeBodyPart();
    	   messageBodyPart.setContent("Please submit your book as soon as possiable", "text/html");

    	   Multipart multipart = new MimeMultipart();
    	   multipart.addBodyPart(messageBodyPart);
    	   MimeBodyPart attachPart = new MimeBodyPart();

    	   attachPart.attachFile("C:\\Users\\Public\\Pictures\\Sample Pictures/Chrysanthemum.jpg");
    	   multipart.addBodyPart(attachPart);
    	   msg.setContent(multipart);
    	   Transport.send(msg);   
    	}
    
    
    /* It Show Uploaded e-book list */
    @RequestMapping(value = "/uploadBookByAdmin", method = RequestMethod.GET)
	public String showUploadForm(@ModelAttribute ("models") ModelMap model) {
    	uploadFileList = (ArrayList<UploadFile>) fileUploadRepository.findAll();
		model.addAttribute("uploadBookList", uploadFileList);
		
		System.out.println("uploadFileList :: " + uploadFileList);
		
		return "upload";
	}
	
    /* It will upload book to database */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request, @RequestParam MultipartFile[] fileUpload) throws Exception {
         
        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile aFile : fileUpload){
                                
                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                
                fileUploadRepository.save(uploadFile);
                
            }
        }
        return "redirect:/uploadBookByAdmin";
    }	
	
    
    
    /* It deletes record for the given id in URL and redirects to /bookList */    
    @RequestMapping(value="/deleteUploadedBook/{id}",method = RequestMethod.GET)    
    public String deleteUploadedBooks(@PathVariable long id){    
    	fileUploadRepository.deleteById(id);
        return "redirect:/uploadBookByAdmin";    
    } 
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
}
//// https://www.opencodez.com/java/spring-batch-with-spring-boot.htm