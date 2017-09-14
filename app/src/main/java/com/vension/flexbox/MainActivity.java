package com.vension.flexbox;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


	String[] tags = {"篮球", "足球", "排球", "唱K", "Android", "iOS",
			"PHP", "Kotlin for Java", "程序员鼓励师", "生活家", "屌丝程序员", "想法",
			"短篇小说", "美食", "教育", "奇思妙想", "飞鸽传情", "NBA直播"};
	private TextView tvTags;
	private List<FlexTagInfo> tagInfos = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		tvTags = (TextView) findViewById(R.id.tv_tags);
		FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
		for (int i = 0; i < tags.length; i++) {
			FlexTagInfo model = new FlexTagInfo();
			model.setId(i);
			model.setName(tags[i]);
			tagInfos.add(model);
			flexboxLayout.addView(createNewFlexItemTextView(model,i));
		}
	}

	/**
	 * 动态创建TextView
	 * @param tagInfo
	 * @return
	 */
	private TextView createNewFlexItemTextView(final FlexTagInfo tagInfo, int index) {
		final TextView textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText(tagInfo.getName());
		textView.setTextSize(12);
		if (index == 0){
			tagInfo.setSelected(true);
			tvTags.setText(tagInfo.getName());
		}
		textView.setTextColor(ContextCompat.getColor(MainActivity.this,tagInfo.isSelected() ? R.color.white : R.color.colorAccent));
		textView.setBackgroundResource(tagInfo.isSelected() ? R.drawable.shape_rect_select : R.drawable.shape_rect_unselect);
		textView.setTag(tagInfo.getId());
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.e("flexbox", tagInfo.getName());
				tagInfo.setSelected(!tagInfo.isSelected());
				Toast.makeText(MainActivity.this,tagInfo.getName(),Toast.LENGTH_LONG).show();
				textView.setTextColor(ContextCompat.getColor(MainActivity.this,tagInfo.isSelected() ? R.color.white : R.color.colorAccent));
				textView.setBackgroundResource(tagInfo.isSelected() ? R.drawable.shape_rect_select : R.drawable.shape_rect_unselect);
			    showTags();
			}
		});
		int padding = Util.dpToPixel(this, 4);
		int paddingLeftAndRight = Util.dpToPixel(this, 8);
		ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, padding, paddingLeftAndRight, padding);
		FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		int margin = Util.dpToPixel(this, 6);
		int marginTop = Util.dpToPixel(this, 16);
		layoutParams.setMargins(margin, marginTop, margin, 0);
		textView.setLayoutParams(layoutParams);
		return textView;
	}

	/**
	 * 显示选中的tag
	 * */
	private void showTags() {
		if (tagInfos.size() > 0){
			StringBuffer _StringBuffer = new StringBuffer("");
			for (int i = 0; i < tagInfos.size(); i++) {
				if (tagInfos.get(i).isSelected()){
					_StringBuffer.append(tagInfos.get(i).getName() + "   ");
				}
			}
			tvTags.setText(_StringBuffer.toString());
		}
	}


}
