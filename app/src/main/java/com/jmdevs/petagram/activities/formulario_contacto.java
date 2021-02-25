package com.jmdevs.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.jmdevs.petagram.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class formulario_contacto extends AppCompatActivity {

    private Session session;
    private String correo;
    private String contra;
    private EditText ti_nombre;
    private EditText ti_mail;
    private EditText et_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        Toolbar actionBar2 = (Toolbar) findViewById(R.id.action_bar2);
        setSupportActionBar(actionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

/*    public void sendMail(View v){
        EditText ti_nombre      = findViewById(R.id.editName);
        EditText ti_mail        = findViewById(R.id.editEmail);
        EditText et_mensaje     = findViewById(R.id.editMensaje);

        String nom      = ti_nombre.getText().toString();
        String mail     = ti_mail.getText().toString();
        String message  = et_mensaje.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, mail);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));

    }*/

    public void sendMail(View v) throws MessagingException {
        ti_nombre      = findViewById(R.id.editName);
        ti_mail        = findViewById(R.id.editEmail);
        et_mensaje     = findViewById(R.id.editMensaje);

        correo = "petagramCoursera2021@gmail.com";
        contra = "coursera20105";

        StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        try{
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo, contra);
                }
            });

            if (session != null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("Petagram comentario tarea4 de "+ti_nombre.getText().toString());
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("petagramCoursera2021@gmail.com"));
                message.setContent(et_mensaje.getText().toString(),"text/html; charset=utf-8");
                Transport.send(message);
                Toast.makeText(getApplicationContext(),"su mensaje fue enviado", Toast.LENGTH_SHORT).show();
            }

            if (session != null){
                Message message2 = new MimeMessage(session);
                message2.setFrom(new InternetAddress(correo));
                message2.setSubject("Petagram comentario tarea4 de "+ti_nombre.getText().toString());
                message2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ti_mail.getText().toString()));
                message2.setContent("comentario enviado a petagram:"+et_mensaje.getText().toString(),"text/html; charset=utf-8");
                Transport.send(message2);
                et_mensaje.setText(" ");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}