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

package com.miz.functions;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.miz.mizuu.R;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

public class CoverItem implements Target {

	public TextView text, subtext;
	public ImageView cover;
	public RelativeLayout layout;
	private int animationDuration = 200;

	@Override
	public void onBitmapFailed(Drawable arg0) {
		cover.setImageResource(R.drawable.loading_image);
		ObjectAnimator.ofFloat(cover, "alpha", 0f, 1f).setDuration(animationDuration).start();
	}
	@Override
	public void onBitmapLoaded(Bitmap arg0, LoadedFrom arg1) {
		cover.setImageBitmap(arg0);
		ObjectAnimator.ofFloat(cover, "alpha", 0f, 1f).setDuration(animationDuration).start();
	}
	@Override
	public void onPrepareLoad(Drawable arg0) {}
}