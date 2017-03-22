package kr.pe.theeye.qrcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.zxing.client.android.integration.IntentIntegrator;
import com.google.zxing.client.android.integration.IntentResult;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				// QR�ڵ�/���ڵ� ��ĳ�ʸ� �����մϴ�.
				IntentIntegrator.initiateScan(MainActivity.this);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// QR�ڵ�/���ڵ带 ��ĵ�� ��� ���� �����ɴϴ�.
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		
		// ����� ���
		new AlertDialog.Builder(this)
			.setTitle(R.string.app_name)
			.setMessage(result.getContents() + " [" + result.getFormatName() + "]")
			.setPositiveButton("Ȯ��", new DialogInterface.OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					dialog.dismiss();
				}
			})
			.show();
	}
}
