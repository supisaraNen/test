package com.example.testrandompic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.CalendarContract.Colors;
import android.util.Log;
import android.widget.Toast;

public class DataBase extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "COS";

	public static final String TABLE2_NAME = "Quiz";
	public static final String COLUMN2_ID = "_id";
	public static final String COLUMN2_QUIZ = "quiz";
	public static final String COLUMN2_ANS = "ans";
	Context context;
	private Vector<getQuiz> quiz_list = new Vector<getQuiz>();

	public DataBase(Context ctx) {
		super(ctx, DATABASE_NAME, null, 1);
		context = ctx;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

//		db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID
//				+ " INTEGER PRIMARY KEY , " + COLUMN_PIC + " TEXT ,"
//				+ COLUMN_RED + " INTEGER ," + COLUMN_GREEN + " INTEGER ,"
//				+ COLUMN_BLUE + " INTEGER" + ");");
//
//		Log.d("CREATE TABLE", "Create Color Table Successfully.");
//
//		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					context.getAssets().open("tablecolor.csv")));
//			String readLine = null;
//			readLine = br.readLine();
//			try {
//				while ((readLine = br.readLine()) != null) {
//					Log.i("Data Input", readLine);
//					String[] str = readLine.split(",");
//					db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID
//							+ ", " + COLUMN_PIC + ", " + COLUMN_RED + ", "
//							+ COLUMN_GREEN + ", " + COLUMN_BLUE + ") VALUES ("
//							+ Integer.parseInt(str[0]) + ",'" + str[1] + "',"
//							+ Integer.parseInt(str[2]) + ","
//							+ Integer.parseInt(str[3]) + ","
//							+ Integer.parseInt(str[4]) + " );");
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);

	}

	public Vector<getQuiz> getAllQuiz() {
		try {
			quiz_list.clear();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						context.getAssets().open("tablequiz.csv")));
				String readLine = null;
				readLine = br.readLine();
				try {
					while ((readLine = br.readLine()) != null) {
						Log.i("Data Input", readLine);
						String[] str = readLine.split(",");
						getQuiz quiz = new getQuiz(Integer.parseInt(str[0]), str[1],
								Integer.parseInt(str[2]));
						quiz_list.add(quiz);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return quiz_list;
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("all_records", "" + e);
		}
		return quiz_list;
	}

	// Getting All Records
//	public Vector<getColor> getAllRecords() {
//		try {
//			color_list.clear();
//			// Select All Query
//			String selectQuery = "SELECT * FROM " + TABLE_NAME;
//			SQLiteDatabase db = this.getWritableDatabase();
//			Cursor cursor = db.rawQuery(selectQuery, null);
//			// looping through all rows and adding to list
//			if (cursor.moveToFirst()) {
//				do {
//					getColor color = new getColor(Integer.parseInt(cursor
//							.getString(0)), cursor.getString(1),
//							Integer.parseInt(cursor.getString(2)),
//							Integer.parseInt(cursor.getString(3)),
//							Integer.parseInt(cursor.getString(4)));
//					color_list.add(color);
//				} while (cursor.moveToNext());
//			}
//			// return contact list
//			cursor.close();
//			db.close();
//			return color_list;
//		} catch (Exception e) {
//			// TODO: handle exception
//			Log.e("all_records", "" + e);
//		}
//		return color_list;
//	}
}
