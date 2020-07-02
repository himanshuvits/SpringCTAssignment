/** @author Himanshu 
  * @Date 02 July 2020
 */

/**
 * @Requirement : 
 * Description: We need to develop a web application that maintains information
 * of different companies and users in the relational database. Design &
 * implement this application and demonstrate the functionality.
 * 
 * Following is the list of functionalities that we need to implement in this
 * application: 1. Add a Company [Name, City] 2. Add a User [Name, Email, Phone]
 * 3. Allocate a User to one or more Companies 4. List Users [Name, Email,
 * Phone, Allocated Companies (comma separated string)] 5. Delete a given
 * Company 6. Get a User’s data for a given Company
 * 
 * Notes: • Implement backend for this web application that provides RESTful
 * APIs. • Assume a suitable authentication mechanism but no need to implement
 * it now. • Instead of implementing API for #1 and #2, you can populate this
 * data in database manually. • It is must to implement #3 as an API. • You have
 * to implement at least one API out of #4, #5 and #6.
 * 
 * Technologies: • Any Java framework like Spring MVC, Spring Boot, Jersey,
 * Angular JS( any version), etc • MySQL • RESTful API
 */

package com.assignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.dao.CompanyDao;
import com.assignment.dao.UserDao;
import com.assignment.dto.Company;
import com.assignment.dto.User;

@RestController
public class AssignmentController {
	@Autowired
	UserDao userDao;

	@Autowired
	CompanyDao companyDao;

	/**
	 * @param
	 * @return List of Users.
	 * @Method : Gets list of all users.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<List<User>> searchUser() {
		return ResponseEntity.ok(userDao.findAll());
	}

	/**
	 * @param UserId.
	 * @return User Object.
	 * @Method : Gets specific user as per user id provided.
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<User> searchUserById(@PathVariable int id) {
		return ResponseEntity.ok(userDao.findByUserId(id));
	}

	/**
	 * @param User Object
	 * @return
	 * @Method : Adds new user to the database.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		userDao.save(user);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param User Object
	 * @return
	 * @Method : Updates user to the database.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userDao.save(user);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param User Object
	 * @return
	 * @Method : Removes any user from database as per user object provided.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.DELETE, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> deleteUser(@RequestBody User user) {
		userDao.delete(user);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param
	 * @return List of Companies.
	 * @Method : Gets list of all companies.
	 */
	@RequestMapping(value = "/company", method = RequestMethod.GET, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<List<Company>> searchCompany() {
		return ResponseEntity.ok(companyDao.findAll());
	}

	/**
	 * @param CompanyId.
	 * @return Company Object.
	 * @Method : Gets specific company details as per comany id provided.
	 */
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<Company> searchCompanyById(@PathVariable int id) {
		return ResponseEntity.ok(companyDao.findByCompanyId(id));
	}

	/**
	 * @param Company Object
	 * @return
	 * @Method : Adds new company to the database.
	 */
	@RequestMapping(value = "/company", method = RequestMethod.POST, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> saveCompany(@RequestBody Company company) {
		companyDao.save(company);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param Company Object
	 * @return
	 * @Method : Updates existing company in the database.
	 */
	@RequestMapping(value = "/company", method = RequestMethod.PUT, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> updateCompany(@RequestBody Company company) {
		companyDao.save(company);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param Company Object
	 * @return
	 * @Method : Deletes existing company from the database.
	 */
	@RequestMapping(value = "/company", method = RequestMethod.DELETE, consumes = "Application/json", produces = "Application/json")
	public ResponseEntity<?> deleteCompany(@RequestBody Company company) {
		companyDao.delete(company);
		return ResponseEntity.ok().build();
	}
}
