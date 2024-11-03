<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.proformat.Proformat" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Proformat> proformats = ((List<Proformat>) request.getAttribute("proformats"));
%>

<div class="card">
    <h5 class="card-header">Liste des Demandes de Proformats pour les clients</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Client</th>
                <th>Date</th>
                <th>Etat</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for (Proformat p : proformats) {
            %>
            <tr>
                <td>
                    <strong>PF000<%=p.getId()%></strong>
                </td>
                <td>
                    CLI000<%=p.getIdClient().getId()%> - <%=p.getIdClient().getNom()%>
                </td>
                <td>
                    <%=p.getDaty()%>
                </td>
                <td>
                    <%=p.getEtatHtml()%>
                </td>
                <td>
                    <a href="/proformat/detailsClient?id=<%=p.getId()%>">
                        <button class="btn btn-primary">Voir Details</button>
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
