package test.com.vote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoteController
 */
@WebServlet({ "/voteOK.do", "/re_voteOK.do", "/m_vote_create.do", "/m_vote_update.do", "/m_vote_view.do", "/m_vote_delete.do", "/m_vote_stateUpdate.do",
			"/a_voteOK.do", "/a_re_voteOK.do", "/a_vote_create.do", "/a_vote_update.do", "/a_vote_view.do", "/a_vote_delete.do", "/a_vote_stateUpdate.do"})
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet() : " + sPath);
		
		if (sPath.equals("/m_vote_view.do")) {
			new M_VoteSelectOneAction().execute(request, response);
		} else if (sPath.equals("/m_vote_delete.do")) {
			new M_VoteDeleteAction().execute(request, response);
		} else if (sPath.equals("/voteOK.do")) {
			new M_VoteResult_InsertAction().execute(request, response);
		} else if (sPath.equals("/re_voteOK.do")) {
			new M_VoteResult_updateAction().execute(request, response);
		} else if(sPath.equals("/m_vote_stateUpdate.do")){
			new M_VoteStateUpdateAction().execute(request, response);
		} 
		
		else if (sPath.equals("/a_vote_view.do")) {
			new A_VoteSelectOneAction().execute(request, response);
		} else if (sPath.equals("/a_vote_delete.do")) {
			new A_VoteDeleteAction().execute(request, response);
		} else if (sPath.equals("/a_voteOK.do")) {
			new A_VoteResult_InsertAction().execute(request, response);
		} else if (sPath.equals("/a_re_voteOK.do")) {
			new A_VoteResult_updateAction().execute(request, response);
		} else if(sPath.equals("/a_vote_stateUpdate.do")){
			new A_VoteStateUpdateAction().execute(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doPost() : " + sPath);
		
		if(sPath.equals("/m_vote_update.do")) {
			new M_VoteUpdateAction().execute(request, response);
		}else if (sPath.equals("/m_vote_create.do")) {
			new M_VoteCreateAction().execute(request, response);
		}else if (sPath.equals("/a_vote_update.do")) {
			new A_VoteUpdateAction().execute(request, response);
		}else if (sPath.equals("/a_vote_create.do")) {
			new A_VoteCreateAction().execute(request, response);
		}
	}

}
