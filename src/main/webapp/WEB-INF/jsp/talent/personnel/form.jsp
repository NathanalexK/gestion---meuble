<%@ page import="com.source.meuble.talent.cv.Cv" %>
<%@ page import="com.source.meuble.utilisateur.UserRole" %><%--
  Created by IntelliJ IDEA.
  User: Miarantsoa
  Date: 11/11/2024
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>

<%
    Cv cv = (Cv) request.getAttribute("cv");
    UserRole[] userRoles = UserRole.values();
%>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Insertion du(de la) nouvel(le) employé(e)</h5>
            </div>
            <div class="card-body">
                <form action="/personnel/generer-contrat" method="POST">
                    <div class="mb-3">
                        <label class="form-label" for="nom-input">nom: </label>
                        <input type="text" class="form-control" id="nom-input" value="<%=cv.getNom()%>" name="nom"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="prenom-input">Prenom: </label>
                        <input type="text" class="form-control" id="prenom-input" value="<%=cv.getPrenom()%>" name="prenom"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="dn-input">Date de naissance: </label>
                        <input type="date" class="form-control" id="dn-input" value="<%=cv.getDateNaissance()%>" name="dateNaissance"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="adresse-input">Adresse: </label>
                        <input type="text" class="form-control" id="adresse-input" value="<%=cv.getAdresse()%>" name="adresse"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="email-input">Adresse e-mail: </label>
                        <input type="text" class="form-control" id="email-input" value="<%=cv.getEmail()%>" name="email"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="tel-input">Telephone: </label>
                        <input type="text" class="form-control" id="tel-input" value="<%=cv.getTelephone()%>" name="telephone"/>
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
                        <textarea type="number" id="details" class="form-control" name="poste"></textarea>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="de-input">Date d'embauche: </label>
                        <input type="date" class="form-control" id="de-input" name="dateEmbauche"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="exp">Salaire:</label>
                        <input type="number" id="exp" step="0.01" class="form-control" name="salaire"/>
                    </div>
                    <input type="hidden" name="idCv" value="<%=cv.getId()%>">
                    <button type="submit" class="btn btn-primary">Valider</button>
                </form>
            </div>
        </div>
    </div>
</div>
