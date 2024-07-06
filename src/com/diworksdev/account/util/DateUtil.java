package com.diworksdev.account.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate() {

		// 現在日時の取得
		Date date = new Date();

		//SQL DATEの定義に対応させるためにjava.sql.Dateのインスタンスでラップされたミリ秒の値を「標準化」する
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// 現在日時を指定フォーマットで文字列に変換する！！
		return simpleDateFormat.format(date);
	}

}
