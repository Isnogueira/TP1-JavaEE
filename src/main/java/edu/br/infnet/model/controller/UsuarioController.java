package edu.br.infnet.model.controller;

import edu.br.infnet.model.domain.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController extends HttpServlet {

    private List<Usuario> usuarios;

    public UsuarioController() {
        super();
        usuarios = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        usuarios.add(usuario);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>Confirmação de cadastro</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<form>\n" +
                "    <div class=\"container\">\n" +
                "        <h3>Usuario " + usuario.getNome() + " cadastrado com sucesso!</h3>\n" +
                "        <hr>\n" +
                "    </div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

            out.println(
                    "        <div class=\"container\">\n" +
                    "             <h4>Quantidade de usuarios cadastrados: " + usuarios.size() + "</h4>" +
                    "             <hr>\n" +
                    "       </div>\n"
            );

        for (Usuario users : usuarios) {
            out.println(
                    "     <div class=\"container\">\n" +
                    "         <h5>Usuario: " + users.getNome() + "</h5>" +
                    "         <hr>" +
                    "      </div>\n"
            );

        }

            out.println(
                    "     <div class=\"container\">\n" +
                    "          <a href=\"login\">Voltar</a>" +
                    "      </div>\n"
            );

       // request.getRequestDispatcher("confirmacao.html").forward(request, response);

    }
}
