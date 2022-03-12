package com.rest.webservice.webservice.Todo;
import org.springframework.web.bind.annotation.*;


//Controller
@RestController
@CrossOrigin ( origins = "http://localhost:4200")
public class HelloWorldController {
    //@RequestMapping(method=RequestMethod.GET,path="/hello-world")
    @GetMapping(path="hello-world")
    public String helloWorld(){
        return "Hello World";
   
    }
    @GetMapping(path="/hello-world-bean")
    public helloWorldBean helloWorldBean(){
        return new helloWorldBean("hello world bean");
    }
    @GetMapping(path="hello-world-bean/path-variable/{name}")
    public helloWorldBean helloworldpathvariable (@PathVariable String name){

        return new helloWorldBean(String.format("hello world ,%s",name));
    }
   // public handleError handleErrorpathvariable (@PathVariable String name)
   // {throw new RuntimeException("Something Went Wrong");}

    
}
