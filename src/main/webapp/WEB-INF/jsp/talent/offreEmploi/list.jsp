<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.proformat.Proformat" %>
<%@ page import="com.source.meuble.talent.offreEmploi.OffreEmploi" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<OffreEmploi> offreEmplois = ((List<OffreEmploi>) request.getAttribute("offreEmplois"));
%>

<div class="card">
    <h5 class="card-header">Liste des offres d"emplois</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Fournisseur publicateur</th>
                <th>Poste à rechercher</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for (OffreEmploi of : offreEmplois) {
            %>
            <tr>
                <td>
                    <strong>OF000<%=of.getId()%></strong>
                </td>
                <td>
                    FRP000<%=of.getIdFournisseurPub().getId()%> - <%=of.getIdFournisseurPub().getNom()%>
                </td>
                <td>
                    <%=of.getIdBesoinRecrutement().getIdRole()%> - <%= of.getIdBesoinRecrutement().getDiplome().getLibelle() %>
                </td>
                <td>
                    <%=of.getDatePublication()%>
                </td>
                <td>
                    <a href="/proformat/details?id=<%=of.getId()%>">
                        <button class="btn btn-primary">Ajouter cv</button>
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
