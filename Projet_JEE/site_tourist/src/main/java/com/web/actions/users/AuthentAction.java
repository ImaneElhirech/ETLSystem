package com.web.actions.users;

	import java.util.List;
	import java.util.Map;

	import org.apache.struts2.convention.annotation.Action;
	import org.apache.struts2.convention.annotation.Result;
	import org.apache.struts2.convention.annotation.ResultPath;
	import org.apache.struts2.interceptor.SessionAware;
	import org.springframework.beans.factory.annotation.Autowired;

	import com.services.UserService;
import com.web.actions.BaseAction;
import com.bo.User;



	@ResultPath("/pages/")
	public class AuthentAction extends BaseAction implements SessionAware {

		/**
		 * utilis�e pour stocker la liste des produits destin�s � afficher dans la
		 * vue
		 */
		private List<User> listClients;

		
		
		
		//contient les donnees du usr saisie en clavier
		private User user;

		private Map<String, Object> session;

		/** injection du service m�tier */
		
		
		
		
		
		@Autowired
		private UserService userService;

		@Action(value = "/simuAuth", results = { 
		@Result(name = "success", type="redirect", location = "/getAllDestinations"),
				@Result(name = "error", type="redirect", location = "/addWordForm") })
		
		
		public String simuAuth() {

			User user = userService.getUserById(Long.valueOf(1));
			

			if (user != null) {
				session.put("user", userService.getUserById(Long.valueOf(1)));
				return SUCCESS;
			}
			else {
				addActionMessage("Les données sont incorrectes");
				return ERROR;
			}

			

		}
		
		


		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService UserService) {
			this.userService = UserService;
		}

		public void setSession(Map<String, Object> pSession) {
			session = pSession;

		}
	}

