/*
 * Copyright (C) 2014 Michell Bak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.miz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperTvShowEpisode extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mizuu_tv_show_episode_data";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table tvshow_episodes (_id INTEGER PRIMARY KEY AUTOINCREMENT, filepath TEXT, " +
			"screenshot_path TEXT, season TEXT, episode TEXT, show_id TEXT, episode_title TEXT, episode_description TEXT, episode_airdate TEXT," +
			"episode_rating TEXT, episode_director TEXT, episode_writer TEXT, episode_gueststars TEXT, date_added TEXT, to_watch TEXT," +
			"has_watched TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT);";
	
	private static final String DATABASE_CREATE_SHOW_ID_INDEX = "create index show_id_index on tvshow_episodes(show_id);";

	private static DbHelperTvShowEpisode instance;
	
	private DbHelperTvShowEpisode(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public static synchronized DbHelperTvShowEpisode getHelper(Context context) {
		if (instance == null)
            instance = new DbHelperTvShowEpisode(context);

        return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
		database.execSQL(DATABASE_CREATE_SHOW_ID_INDEX);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS tvshow_episodes");
		onCreate(db);
	}

}