<%@ page import="com.source.meuble.etatFinancier.EtatFinancierDTO" %>
<%@ page import="com.source.meuble.etatFinancier.posteFille.PosteFille" %>
<%@ page import="com.source.meuble.analytique.exercice.Exercice" %>
<%@ page import="com.source.meuble.etatFinancier.Poste.PosteCpl" %>
<%@ page import="com.source.meuble.etatFinancier.nomPoste.NomPoste" %>
<%@ page import="com.source.meuble.etatFinancier.bilan.BilanEtatFinancierImpl" %>
<%
    Exercice exercice = (Exercice) request.getAttribute("exercice");
    EtatFinancierDTO etatFinancier = (EtatFinancierDTO) request.getAttribute("etatFinancier");
    BilanEtatFinancierImpl bilan = etatFinancier.getBef();
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    body {
        font-family: Arial, sans-serif;
        /*margin: 20px;*/
        line-height: 1.5;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f4f4f4;
    }
    caption {
        font-weight: bold;
        margin-bottom: 10px;
    }
    .sub-item {
        padding-left: 40px; /* Décalage pour les sous-Postes */
        font-style: italic;
    }
</style>

<div class="card">
    <div class="card-body">
        <h1>États Financiers : exercice <%=exercice.getAnnee()%> <%=etatFinancier.getBef().getRevenu()%></h1>

        <h2>Bilan</h2>
        <% if (!etatFinancier.isValidite()) { %>
            <div class="alert alert-danger">
                Votre bilan n'est pas balancé :
                <%=etatFinancier.getMessageValidite()%>
            </div>
        <% } %>
        <div style="display: flex">
            <table class="col-6">
                <caption>Actifs</caption>
                <thead>
                <tr>
                    <th>Poste Actifs</th>
                    <th>Montant (Ar)</th>
                </tr>
                </thead>
                <tbody>
                    <% for (PosteCpl poste : etatFinancier.getActif()) { %>
                    <tr>
                        <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                        <th><%=poste.getTotal()%></th>
                    </tr>
                        <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) { %>
                    <tr>
                        <td class="sub-item"><a class="btn" href="/poste-fille/delete/<%=pf.getId()%>"><i class="bx bx-x"></i></a> <%=pf.getLibelle()%></td>
                        <td><%=pf.getMontant()%></td>
                    </tr>
                        <% } %>
                        <% for (NomPoste nom : poste.getIdMere().getVides()) { %>
                    <tr>
                        <td class="sub-item"><%=nom.getLibelle()%></td>
                        <td>0</td>
                    </tr>
                        <% } %>
                    <% } %>
                    </tbody>

                <%--            <tr>--%>
                <%--                <td>Actifs (Total)</td>--%>
                <%--                <td>100,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td class="sub-item">Immobilisations</td>--%>
                <%--                <td>60,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td class="sub-item">Stocks</td>--%>
                <%--                <td>20,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td class="sub-item">Créances clients</td>--%>
                <%--                <td>15,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td class="sub-item">Trésorerie</td>--%>
                <%--                <td>5,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td>Passifs (Total)</td>--%>
                <%--                <td>70,000</td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
                <%--                <td>Capitaux propres</td>--%>
                <%--                <td>30,000</td>--%>
                <%--            </tr>--%>
                <%--            </tbody>--%>
                <tfoot>
                    <tr>
                        <th>somme</th>
                        <th><%=etatFinancier.getTotaux().get(0)%></th>
                    </tr>
                </tfoot>
            </table>
            <table class="col-6">
                <caption>Passifs</caption>
                <thead>
                <tr>
                    <th>Poste passifs</th>
                    <th>Montant (Ar)</th>
                </tr>
                </thead>
                <tbody>
                    <% for (PosteCpl poste : etatFinancier.getPassif()) { %>
                <tr>
                    <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                    <th><%=poste.getTotal()%></th>
                </tr>
                    <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) { %>
                <tr>
                    <td class="sub-item"><a class="btn" href="/poste-fille/delete/<%=pf.getId()%>"><i class="bx bx-x"></i></a> <%=pf.getLibelle()%></td>
                    <td><%=pf.getMontant()%></td>
                </tr>
                    <% } %>
                    <% for (NomPoste nom : poste.getIdMere().getVides()) { %>
                <tr>
                    <td class="sub-item"><%=nom.getLibelle()%></td>
                    <td>0</td>
                </tr>
                    <% } %>
                    <% } %>

                </tbody>
                <tfoot>
                <tr>
                    <th>somme</th>
                    <th><%=etatFinancier.getTotaux().get(1)%></th>
                </tr>
                </tfoot>
            </table>
        </div>

        <h2>Resultat Ordonnee</h2>

        <table>
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

        <h2>Compte de Résultat</h2>
        <table>
            <caption>Produits et Charges</caption>
            <thead>
            <tr>
                <th>Poste</th>
                <th>Montant (Ar)</th>
            </tr>
            </thead>
            <tbody>
            <% for (PosteCpl poste : etatFinancier.getResultat()) { %>
            <tr>
                <th><%=poste.getIdMere().getLibelle()%> (Total)</th>
                <th><%=poste.getTotal()%></th>
            </tr>c
            <% for (PosteFille pf : poste.getIdMere().getPosteFilles()) { %>
            <tr>
                <td class="sub-item"><a class="btn" href=""><i class="bx bx-x"></i></a> <%=pf.getLibelle()%></td>
                <td><%=pf.getMontant()%></td>
            </tr>
            <% } %>
            <% } %>
            </tbody>
            <tfoot>
            <tr>
                <th>Resultat net</th>
                <th><%=etatFinancier.getResultatNet()%></th>
            </tr>
            </tfoot>
        </table>

    </div>



    <div class="card-footer">
        <% if(etatFinancier.isValidite()) { %>
            <div class="d-flex justify-content-center">
            <a href="etat-financier/interpretation"><button class="btn btn-primary">Interpreter</button></a>
        </div>
        <% } else { %>
            <div class="alert alert-danger">La balance doit etre equilibre pour Interpreter</div>
        <% } %>
    </div>

</div>