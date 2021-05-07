package com.dakam.quiz.gameQuiz.serverlets;
import com.dakam.quiz.gameQuiz.logic.Thequiz;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "Quiz", value = "/quiz")
public class Quiz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object quiz = session.getAttribute("quiz");
        int marks=0;
        String nextqn="";
        int answered=0;

        if(quiz == null) {
            session.setAttribute("quiz", new Thequiz());

        }
        Thequiz myquiz = (Thequiz) session.getAttribute("quiz");

        String ans = request.getParameter("ans");
        String pseq = request.getParameter("pseq");

        if(ans != null && !ans.equals("") && pseq !=null && !pseq.equals("")) {

            pseq = pseq.trim();

           int cans = (int) myquiz.getQuizMap().get(pseq);
            myquiz.addAnswered();
            myquiz.RecorddoneQuiz(pseq);

            if(Integer.valueOf(ans) == cans) {

                myquiz.addMarks(1);

            } else {
                myquiz.addMarks(0);

           }

        }
            marks = myquiz.getMarks();
            answered = myquiz.getAnswered();
            session.setAttribute("quiz", myquiz);

            if(answered == 5) {

                request.setAttribute("quiz", myquiz);
                request.setAttribute("marks", marks);
                RequestDispatcher rd = request.getRequestDispatcher("complete.jsp");
                rd.forward(request, response);

            } else {


                Iterator quiziterator = myquiz.getQuizMap().entrySet().iterator();
                while (quiziterator.hasNext()) {
                    Map.Entry mapElement = (Map.Entry)quiziterator.next();
                    String qn =  (String) mapElement.getKey() ;
                    if(! myquiz.getDoneQuiz().contains(qn)) {

                        nextqn = qn;
                    }

                }

                String seq = nextqn;
                request.setAttribute("quiz", myquiz);
                request.setAttribute("marks", marks);
                request.setAttribute("seq", seq);

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    }

