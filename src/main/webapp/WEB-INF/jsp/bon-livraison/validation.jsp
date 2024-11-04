<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.vente.BonLivraison.BonLivraison" %>
<%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BonLivraison> bls = ((List<BonLivraison>) request.getAttribute("bls"));
%>

<div class="card">
    <h5 class="card-header">Liste Bon de Livraison à Valider</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>ID Bon de Commande</th>
                <th>Date de Livraison</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
                <%
                    for(BonLivraison bl: bls) {
                %>
                <tr>
                    <td>BL000<%=bl.getId()%></td>
                    <td>BC000<%=bl.getIdBc().getId()%></td>
                    <td><%=bl.getDateLivraison()%></td>
                    <td>
                        <a href="/bon-commande/details?id=<%=bl.getId()%>&type=fournisseur" >
                            <button class="btn btn-primary">Voir Details</button>
                        </a>
                        <a href="/bon-commande/valider?id=<%=bl.getId()%>">
                            <button class="btn btn-warning">Valider</button>
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
