 package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.service.UserService;

  @RestController
  public class LoginRestCrt {
      @Autowired
      UserService uService;
      
      /*@RequestMapping(value="/login")
      public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	  model.addAttribute("name", name);
    	  return "greeting";
     }
      @RequestMapping(method=RequestMethod.POST,value="/hero")
      public void addHero(@RequestBody Hero hero) {
          hService.addHero(hero);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/hero/{id}")
      public Hero getHero(@PathVariable String id) {
          Hero h=hService.getHero(Integer.valueOf(id));
          return h;
      }
*/
}
