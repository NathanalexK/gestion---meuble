<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.etatFinancier.interpretation.Socle" %>
<%--
  Created by IntelliJ IDEA.
  User: miarantsoa
  Date: 13/01/2025
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>

<%
    List<Socle> socles = (List<Socle>) request.getAttribute("data");
    String[] libelle = {"Marge nette", "Retour sur actif (ROA)", "Retour sur capitaux propres (ROE)", "Ratio de liquidité général", "Ratio de liquidité reduite", "Ratio d'endettement global", "Couverture des intérêts"};
%>

<div class="card">
    <div class="card-header">
        <h5>Solutions</h5>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col-md-4 d-flex flex-column py-5">
                <% for(int i=0 ; i < 7 ; i++) {%>
                    <div class="h-10 border border-bottom-3 d-flex justify-content-start align-items-center cursor-pointer p-2" onclick="showSolutions(<%=socles.get(i).getIdIndicateur()-1%>)">
                        <p><%=libelle[i]%>: <%=String.format("%.2f", socles.get(i).getData())%></p>
                        <input type="hidden" name="" class="idIndic" value="<%=socles.get(i).getIdIndicateur()%>">
                        <input type="hidden" name="" class="data" value="<%=socles.get(i).getData()%>">
                    </div>
                <% } %>
            </div>
            <div class="col-md-8 border border-1 rounded-2 py-5" id="rep">
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/interpretation.js"></script>