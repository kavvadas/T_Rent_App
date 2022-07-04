package gr.aueb.sweng22.team11.domain;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Notification {

    private String content;
    private LocalDate date;

    public Notification(){}
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification(String content){
        this.content = content;
        this.date = LocalDate.now();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDateOfNotification(LocalDate DateOfNotification){this.date = DateOfNotification;}

    public LocalDate getDateOfNotification() {
        return date;
    }
}
