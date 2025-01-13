<%@ page import="com.source.meuble.etatFinancier.bilan.BilanEtatFinancier" %>
<%@ page import="com.source.meuble.etatFinancier.bilan.Seuil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.etatFinancier.interpretation.Socle" %>
<%@ page import="java.util.ArrayList" %><%--
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

    double[] pourcentages = {bilan.getMargeNette()/100, bilan.getRetourSurActif()/100, bilan.getRetourSurCapitauxPropres()/100, bilan.getRatioLiquiditeGeneral(), bilan.getRatioLiquiditeReduite(), bilan.getRatioEndettementGlobal()/100, bilan.getCouvertureDesInterets()};
    List<Socle> socles = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
        socles.add(new Socle(i+1, pourcentages[i]));
    }
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
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Marge Nette</td>
                <td><%=String.format("%.2f", bilan.getMargeNette())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilMargeNette())%>"></td>
            </tr>
            <tr>
                <td>Retour Sur Actif (ROA)</td>
                <td><%=String.format("%.2f", bilan.getRetourSurActif())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRetourSurActif())%>"></td>
            </tr>
            <tr>
                <td>Retour Sur Capitaux Propres (ROE)</td>
                <td><%=String.format("%.2f", bilan.getRetourSurCapitauxPropres())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRetourSurCapitauxPropres())%>"></td>
            </tr>
            <tr>
                <td>Ratio de Liquidite General</td>
                <td><%=String.format("%.2f", bilan.getRatioLiquiditeGeneral())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioLiquiditeGeneral())%>"></td>
            </tr>
            <tr>
                <td>Ratio de Liquidite Reduite</td>
                <td><%=String.format("%.2f", bilan.getRatioLiquiditeReduite())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioLiquiditeReduite())%>"></td>
            </tr>
            <tr>
                <td>Ratio d'Endettement Global</td>
                <td><%=String.format("%.2f", bilan.getRatioEndettementGlobal())%>%</td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilRatioEndettementGlobal())%>"></td>
            </tr>
            <tr>
                <td>Couverture des Interets</td>
                <td><%=String.format("%.2f", bilan.getCouvertureDesInterets())%></td>
                <td class="<%=utils.getSeuilClassName(bilan.getSeuilCouverureDesInterets())%>"></td>
            </tr>
            </tbody>
        </table>

    </div>
    <form action="${pageContext.request.contextPath}/socle/interpretation" method="post">
        <% for(int i=0; i < socles.size(); i++) {%>
        <input type="hidden" name="idIndicateur[]" value="<%=socles.get(i).getIdIndicateur()%>">
        <input type="hidden" name="data[]" value="<%=socles.get(i).getData()%>">
        <% } %>
        <button class="mx-5 my-1 btn btn-primary" type="submit">Solutionner</button>
    </form>
    <div id="rep-div" class="d-flex justify-content-center align-items-center"></div>
</div>

