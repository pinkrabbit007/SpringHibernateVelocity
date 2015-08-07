package shiyanlou.test.hibernate.controller;
   
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

@Controller  
@RequestMapping("home.do")
public class HomeController {
	
	 private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(method = { RequestMethod.POST,
			RequestMethod.GET })  
    public String login2()
    {    
        return "home";
    }  

}
 

 
/*    private boolean checkParams(String[] params){  
        for(String param:params){  
            if(param==""||param==null||param.isEmpty()){  
                return false;  
            }  
        }  
        return true;  
    }*/
 
