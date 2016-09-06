package rtsp.example.com.rtspsample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener {

    EditText rtspUrl;
    Button playButton;
    VideoView videoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtspUrl = (EditText) this.findViewById(R.id.editText);
        videoView = (VideoView) this.findViewById(R.id.rtspVideo);
        playButton = (Button) this.findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playButton:
                RtspStream(rtspUrl.getEditableText().toString());
                break;
        }
    }

    private void RtspStream(String rtspUrl) {
        videoView.setVideoURI(Uri.parse(rtspUrl));
        videoView.requestFocus();
        videoView.start();
    }
}