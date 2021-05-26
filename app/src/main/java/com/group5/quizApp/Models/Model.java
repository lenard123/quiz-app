package com.group5.quizApp.Models;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import com.group5.quizApp.*;
import java.io.*;
import android.widget.*;

public class Model
{
	//private static String path = "/mnt/sdcard/SQLiteManager/quizapp.db";
	private static String path ="/data/data/com.group5.quizApp/quizapp";
	private static String version_path = "/data/data/com.group5.quizApp/version.txt";
	private static SQLiteDatabase db;

	public static SQLiteDatabase GetDatabase()
	{
		if (db == null)
		{
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
		}
		return db;
	}
	
	public static SQLiteDatabase GetAssetDatabase()
	{
		//SQLiteDatabase db = SQLiteDatabase.openDatabase(
		return null;
	}

	public static void _copydatabase(Context context) throws IOException
	{
		
		if (UpdateDatabase())
		{
			String DbName = "quizapp";
			OutputStream myOutput = new FileOutputStream(path);
			byte[] buffer = new byte[1024];
			int length;
			InputStream myInput = context.getAssets().open(DbName);
			while ((length = myInput.read(buffer)) > 0)
			{
				myOutput.write(buffer, 0, length);
			}
			myInput.close();
			myOutput.flush();
			myOutput.close();
			UpdateVersion();
		}
	}
	
	private static void UpdateVersion()
	{
		try {
			File version = new File(version_path);
			FileWriter writer = new FileWriter(version);
			writer.write(Config.DB_VERSION+"");
			//writer.append(sBody);
			writer.flush();
			writer.close();
			//Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
			//Toast.makeText(e.getMessage());
		}
	}
		
	private static int GetVersion()
	{
		int res = 0;
		File version = new File(version_path);
		if(version.exists()){
			StringBuilder text = new StringBuilder();
			try {
				BufferedReader br = new BufferedReader(new FileReader(version));
				String line;

				while ((line = br.readLine()) != null) {
					text.append(line);
					//text.append('\n');
				}
				br.close();
				res = Integer.parseInt(text.toString());
			}
			catch (Exception e) {
				
			}
		}
		return res;
	}
	
	private static boolean UpdateDatabase()
	{
		return Config.DB_VERSION >  GetVersion();
	}



}
