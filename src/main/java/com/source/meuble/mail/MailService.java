package com.source.meuble.mail;

import com.source.meuble.exception.Alert;
import com.source.meuble.talent.cv.Cv;
import com.source.meuble.talent.personnel.Personnel;
import com.source.meuble.util.AlertType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(SimpleMailMessage mail) {
        javaMailSender.send(mail);
    }

    public void sendEntrepriseMail(String to, String subject, String text) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("jpdecker9@gmail.com", "Mr Meuble");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        javaMailSender.send(mimeMessage);
    }

    public void accepterCV(Cv cv, LocalDate date) throws Alert, MessagingException, UnsupportedEncodingException {
        if(cv.getEmail() == null) {
            Alert alert = new Alert(AlertType.WARNING, "Erreur", "L'email est du postuleur est requis");
            throw alert;
        }
        String content = """
            Cher :nom :prenom,
            Merci  d'avoir postulé au poste chez Mr Meuble.
            Après avoir examiné vos documents de candidature, nous sommes heureux de procéder à l'entretien.
            Nous aimerions vous inviter à un entretien dans nos bureaux. Vous passerez l'entretien le :date
        """
            .replace(":nom", cv.getNom())
            .replace(":prenom", cv.getPrenom())
            .replace(":date", date.toString())
        ;
        sendEntrepriseMail(cv.getEmail(), "Reponse candidature", content);
    }

    public void refuserCV(Cv cv) throws Alert, MessagingException, UnsupportedEncodingException {
        if(cv.getEmail() == null) {
            Alert alert = new Alert(AlertType.WARNING, "Erreur", "L'email est du postuleur est requis");
            throw alert;
        }
        String content = """
            Madame/Monsieur :prenom,
                    
                    Nous tenons à vous remercier pour l’intérêt que vous avez porté à notre entreprise et pour le temps consacré à votre candidature au sein de Mr Meuble.
                    
                    Après une étude attentive de votre profil, nous avons le regret de vous informer que nous ne pouvons donner une suite favorable à votre candidature. 
                    Cette décision n'enlève rien à la qualité de votre parcours ni à vos compétences,qui sont tout à fait appréciables. Cependant, nous avons privilégié un candidat dont le profil correspond plus étroitement à nos besoins actuels.
        """
                .replace(":prenom", cv.getPrenom())
                ;
        sendEntrepriseMail(cv.getEmail(), "Reponse candidature", content);
    }

    public void accepterEssai(Personnel cv) throws Alert, MessagingException, UnsupportedEncodingException {
        if(cv.getEmail() == null) {
            Alert alert = new Alert(AlertType.WARNING, "Erreur", "L'email est de l'employé est requis");
            throw alert;
        }

        String content = """
                Madame/Monsieur :nom :prenom,
                                
                Nous avons le plaisir de vous informer que suite à notre entretien, nous avons été convaincus par votre profil et votre expérience. C’est avec enthousiasme que nous vous proposons de rejoindre notre équipe en tant que :poste :detail au sein de Mr Meuble.
                """
                .replace(":nom", cv.getNom())
                .replace(":prenom", cv.getPrenom())
                .replace(":poste", cv.getIdRole().toString())
                .replace(":detail", cv.getPoste())
                ;
        sendEntrepriseMail(cv.getEmail(), "Reponse entretien", content);
    }
}
