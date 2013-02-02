package org.codechimp.appchooserdemo;

import org.codechimp.appchooser.AppChooser;
import org.codechimp.appchooser.AppChooserListener;
import org.codechimp.appchooser.AppItem;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements AppChooserListener  {

	private Button buttonTest;
	private TextView textviewSelected;
	private AppChooserListener activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;
		
		buttonTest = (Button) findViewById(R.id.button1);
		
		textviewSelected = (TextView) findViewById(R.id.textview2);
		
		buttonTest.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				AppChooser.showChooserDialog(v.getContext(), activity);
				
			}
		});

	}

	@Override
	public void onAppSelected(AppItem value) {

		textviewSelected.setText(value.getPackageName());
		
	}

	@Override
	public void onDismiss() {
		textviewSelected.setText("Dismissed");
		
	}


}
