<%@ page import="com.source.meuble.etatFinancier.bilan.BilanEtatFinancier" %>
<%@ page import="com.source.meuble.etatFinancier.bilan.Seuil" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 03/01/2025
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>

<%
    BilanEtatFinancier bilan = ((BilanEtatFinancier) request.getAttribute("bilan"));

    class Utils {
        String getSeuilClassName(Seuil seuil) {
            if(seuil == Seuil.BAS) return "bg-label-danger";
            if(seuil == Seuil.MOYEN) return "bg-label-warning";
            return "bg-label-success";
        }
    }

    Utils utils = new Utils();
%>


<div class="card">
    <div class="card-header">
        <h5>Interpretation Etat Financier</h5>
    </div>

    <div class="card-body">
        <table class="table table-bordered ">
            <thead>
            <tr>
                <th>Libelle</th>
                <th>Valeur</th>
                <th>Seuil</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Marge Nette</td>
                <td><%=String.format("%.2f", bilan.getMargeNette())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilMargeNette())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            <tr>
                <td>Retour Sur Actif (ROA)</td>
                <td><%=String.format("%.2f", bilan.getRetourSurActif())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRetourSurActif())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>

            </tr>
            <tr>
                <td>Retour Sur Capitaux Propres (ROE)</td>
                <td><%=String.format("%.2f", bilan.getRetourSurCapitauxPropres())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRetourSurCapitauxPropres())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            <tr>
                <td>Ratio de Liquidite General</td>
                <td><%=String.format("%.2f", bilan.getRatioLiquiditeGeneral())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioLiquiditeGeneral())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            <tr>
                <td>Ratio de Liquidite Reduite</td>
                <td><%=String.format("%.2f", bilan.getRatioLiquiditeReduite())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioLiquiditeReduite())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            <tr>
                <td>Ratio d'Endettement Global</td>
                <td><%=String.format("%.2f", bilan.getRatioEndettementGlobal())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioEndettementGlobal())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            <tr>
                <td>Couverture des Interets</td>
                <td><%=String.format("%.2f", bilan.getCouvertureDesInterets())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilCouverureDesInterets())%>"></td>
                <td><button class="btn btn-primary">Voir Suggestion</button></td>
            </tr>
            </tbody>




        </table>

    </div>
</div>