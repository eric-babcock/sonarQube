/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonarqube.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric Babcock <ebabcock@uni-koblenz.de>
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"USER", "ADMIN"}))
public class UserAndAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1046L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//manager and admin are allowed in, the employee stays outside with a SecurityException
        }
}
