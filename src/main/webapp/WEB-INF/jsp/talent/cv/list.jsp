<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.proformat.Proformat" %>
<%@ page import="com.source.meuble.talent.offreEmploi.OffreEmploi" %>
<%@ page import="com.source.meuble.talent.cv.Cv" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Cv> cvs = (List<Cv>) request.getAttribute("cvs");
%>

<div class="card">
    <h5 class="card-header">Liste des Cv: Offre d'emploi N°: <%=cvs.get(0).getIdOffreEmploi().getId()%></h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom - prenom</th>
                <th>Poste à rechercher</th>
                <th>Date postulation</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for (Cv cv : cvs) {
            %>
            <tr>
                <td>
                    <strong>OF000<%=cv.getId()%></strong>
                </td>
                <td>
                    <%=cv.getNom()%> <%=cv.getPrenom()%>
                </td>
                <td>
                    Unknow information --to-complete
                </td>
                <td>
                    <%=cv.getDatePostulation()%>
                </td>
                <td>
                    <a href="/test/form?id=<%=cv.getId()%>">
                        <button class="btn btn-primary">Tester</button>
                    </a>
                    <a href="/cv/form/<%=cv.getId()%>">
                        <button class="btn btn-dark">Details</button>
                    </a>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>
