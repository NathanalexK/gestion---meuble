<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.bonCommande.BonCommande" %>
<%@ page import="com.source.meuble.vente.BonLivraison.BonLivraison" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BonLivraison> bls = ((List<BonLivraison>) request.getAttribute("bls"));
%>

<div class="card">
    <h5 class="card-header">Liste Bon de Livraison</h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>ID Bon de Commande</th>
                <th>Date Livraison</th>
                <th>Etat</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for(BonLivraison bl: bls) {
            %>
                <tr>
                    <td class="bold">BL000<%=bl.getId()%></td>
                    <td>BC000<%=bl.getIdBc().getId()%></td>
                    <td><%=bl.getDateLivraison()%></td>
                    <td><%=bl.getEtat()%></td>
                    <td>
                        <a href="/bon-livraison/details?id=<%=bl.getId()%>">
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

