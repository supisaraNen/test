package com.example.testrandompic;

import java.util.Random;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public Vector<Integer> checkQuiz = new Vector<Integer>();
	
	public void selectQuiz(){
		DataBase mydb = new DataBase(this);
		mydb.getWritableDatabase();
		Vector<getQuiz> quiz_list = mydb.getAllQuiz();
		ImageView quiz = (ImageView)findViewById(R.id.imageView1);
		Random r = new Random();
		int Low = 0;
		int High = 10;
		int chooseQuiz;
		Toast toast = Toast.makeText ( MainActivity.this, quiz_list.size(), Toast.LENGTH_LONG );
		toast.show ( );
//		for(int i = 0;i<quiz_list.size();){
//			chooseQuiz = r.nextInt(High-Low) + Low;
//			if(checkQuiz.size() == 0){
//				checkQuiz.add(chooseQuiz);
//				Resources resources = this.getResources ( );
//				int resourceID = resources.getIdentifier ( quiz_list.get(chooseQuiz).getQuiz(), "drawable", "com.example.testrandompic" );
//				quiz.setImageResource(resourceID);
//				i++;
//			}
//			else{
//				for(int j = 0;j<checkQuiz.size();j++){
//					if(chooseQuiz == checkQuiz.get(j)){
//						chooseQuiz = r.nextInt(High-Low) + Low;
//					}
//				}
//			}
//			if(checkQuiz.size()==quiz_list.size()){
//				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//
//				// set title
//				alertDialogBuilder.setTitle("Finish");
//
//				// set dialog message
//				alertDialogBuilder
//						.setMessage("Thank You!!")
//						.setCancelable(false)
//						.setPositiveButton("OK!!",
//								new DialogInterface.OnClickListener() {
//									public void onClick(DialogInterface dialog, int id) {
//										// if this button is clicked, close
//										// current activity
//									}
//								});
//
//				// create alert dialog
//				AlertDialog alertDialog = alertDialogBuilder.create();
//
//				// show it
//				alertDialog.show();
//			}
//		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button startBtn = (Button)findViewById(R.id.button1);
		
		startBtn.setOnClickListener ( new View.OnClickListener ( )
		{
			public void onClick ( View v )
			{
				selectQuiz();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
