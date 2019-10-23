package firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import vo.LinkVO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FireBase {
    DatabaseReference ref;
    public FireBase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/discordbot-a04b9-firebase-adminsdk-wbpt1-08069a736e.json");

            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://discordbot-a04b9.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("image");
    }

    public void insertData(ArrayList<String> links) {
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
        ref.push().setValueAsync(new LinkVO(time, links));
    }
}