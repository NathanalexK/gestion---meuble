<%@ page import="com.source.meuble.analytique.exercice.Exercice" %>
<%@ page import="com.source.meuble.etatFinancier.analyse.AnalyseEtaFinancier" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.etatFinancier.Poste.PosteCpl" %>
<%@ page import="com.source.meuble.etatFinancier.posteFille.PosteFille" %>
<%@ page import="com.source.meuble.etatFinancier.bilan.BilanEtatFinancierImpl" %><%--
  Created by IntelliJ IDEA.
  User: Tsinjoniaina
  Date: 1/11/2025
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Exercice exercice = (Exercice) request.getAttribute("exercice");
    AnalyseEtaFinancier analyseEtaFinancier = (AnalyseEtaFinancier) request.getAttribute("analyse");
    BilanEtatFinancierImpl bilan = analyseEtaFinancier.getBilanEtatFinancier();
%>
<style>
    .sub-level {
        padding-left: 20px;
        font-style: italic;
    }
</style>
<div class="card">
    <div class="card-body">
        <h1>États Financiers : exercice <%=exercice.getAnnee()%></h1>

        <h2>Bilan</h2>
        <% if (!analyseEtaFinancier.isValide()) { %>
        <div class="alert alert-danger">
            Votre bilan n'est pas balancé :
            <%=analyseEtaFinancier.getMessageValidite()%>
        </div>
        <% } %>
        <h2 class="">Actif</h2>
        <table class="table table-bordered">

            <caption>Actifs</caption>
            <thead>
            <tr>
                <th>Poste Actifs</th>
                <th>Montant (Ar)</th>
            </tr>
            </thead>
            <tbody>
                <% for (PosteCpl poste : analyseEtaFinancier.getActifs()) { %>
                <tr>
                    <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                    <th><%=poste.getTotal()%></th>
                </tr>
                    <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) {
                        if(pf.getMontant()!=0 || true) {
                            out.println(pf.getHtml(1));
                        }
                    }
                } %>
            </tbody>
            <tfoot>
            <tr>
                <th>Total des actifs</th>
                <th><%=analyseEtaFinancier.getTotaux().get(0)%></th>
            </tr>
            </tfoot>
        </table>
        <h2>Passif</h2>
        <table class="table table-bordered">
            <caption>Passifs</caption>
            <thead>
            <tr>
                <th>Poste Passifs</th>
                <th>Montant (Ar)</th>
            </tr>
            </thead>
            <tbody>
                <% for (PosteCpl poste : analyseEtaFinancier.getPassifs()) { %>
                    <tr>
                        <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                        <th><%=poste.getTotal()%></th>
                    </tr>
                    <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) {
                        if(pf.getMontant()!=0 || true) {
                            out.println(pf.getHtml(1));
                        }
                    }
                } %>
            </tbody>
            <tfoot>
            <tr>
                <th>Total des passifs</th>
                <th><%=analyseEtaFinancier.getTotaux().get(1)%></th>
            </tr>
            </tfoot>
        </table>

        <h2>Compte de Résultat</h2>
        <table class="table table-bordered">
            <caption>Produits et Charges</caption>
            <thead>
            <tr>
                <th>Poste</th>
                <th>Montant (Ar)</th>
            </tr>
            </thead>
            <tbody>
                <% for (PosteCpl poste : analyseEtaFinancier.getResultat()) { %>
                    <tr>
                        <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                        <th><%=poste.getTotal()%></th>
                    </tr>
                    <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) {
                        if(pf.getMontant()!=0 || true) {
                            out.println(pf.getHtml(1));
                        }
                    }
                } %>
            </tbody>
            <tfoot>
            <tr>
                <th>Resultat Net</th>
                <th><%=analyseEtaFinancier.getTotaux().get(2)%></th>
            </tr>
            </tfoot>
        </table>

        <h2>Resultat Ordonnee</h2>
        <table class="table table-bordered">
            <%--            <caption>Produits et Charges</caption>--%>
            <thead>
            <tr>
                <th>Poste</th>
                <th>Montant (Ar)</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td class="sub-item"> Revenu </td>
                <td> <%=bilan.getRevenu()%>  </td>
            </tr>

            <tr>
                <td class="sub-item"> Charge d'exploitation </td>
                <td> <%=bilan.getChargeFinanciere()%> </td>
            </tr>

            <tr>
                <td class="sub-item"> Resultat d'exploitation </td>
                <td> <%=bilan.getResultatExploitation()%> </td>
            </tr>

            <tr>
                <td class="sub-item"> Charge financiere  </td>
                <td> <%=bilan.getChargeFinanciere()%> </td>
            </tr>

            <tr>
                <td class="sub-item"> Impots  </td>
                <td> <%=bilan.getImpots()%></td>
            </tr>

            </tbody>
            <tfoot>
            <tr>
                <th>Resultat net</th>
                <th><%=bilan.getResultatNet()%></th>
            </tr>
            </tfoot>
        </table>
    </div>



    <div class="card-footer">
        <% if(analyseEtaFinancier.isValide()) { %>
        <div class="d-flex justify-content-center">
            <a href="/etat-financier/interpretation"><button class="btn btn-primary">Interpreter</button></a>
        </div>
        <% } else { %>
        <div class="alert alert-danger">La balance doit etre equilibre pour Interpreter</div>
        <% } %>
    </div>

</div>