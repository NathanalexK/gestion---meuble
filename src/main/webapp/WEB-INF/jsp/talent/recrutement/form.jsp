<%@ page import="com.source.meuble.talent.diplome.Diplome" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.utilisateur.UserRole" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Miarantsoa
  Date: 10/11/2024
  Time: 02:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Diplome> dipl = (List<Diplome>) request.getAttribute("dipl");
    UserRole[] userRoles = UserRole.values();
%>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Recrutement</h5>
            </div>
            <div class="card-body">
                <form action="/recrutement/save" method="POST">
                    <div class="mb-3">
                        <label class="form-label" for="date-input">Date: </label>
                        <input type="date" class="form-control" id="date-input" value="<%=LocalDate.now()%>" name="dateDemande"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="role">Poste: </label>
                        <select name="idRole" id="role" class="form-select">
                            <%
                                for(UserRole role: userRoles) {
                            %>
                            <option value="<%=role%>"><%=role%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="details">Details du poste:</label>
                        <textarea type="number" id="details" class="form-control" name="details"></textarea>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="diplome">Diplome: </label>
                        <select name="diplome.id_diplome" id="diplome" class="form-select">
                            <%
                                for(Diplome d: dipl) {
                            %>
                            <option value="<%=d.getId_diplome()%>"><%=d.getLibelle()%> - Niveau <%=d.getNiveau()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="exp">Annees d'experience:</label>
                        <input type="number" id="exp" class="form-control" name="anneesExperience"/>
                    </div>
                    <input type="hidden" name="etat" value="0">
                    <button type="submit" class="btn btn-primary">Valider</button>
                </form>
            </div>
        </div>
    </div>
</div>