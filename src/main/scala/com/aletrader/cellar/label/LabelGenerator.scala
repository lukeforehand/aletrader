package com.aletrader.cellar.label;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.File;

import org.apache.commons.io.IOUtils;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

object LabelGenerator {

	def generate() : Array[Byte] = {
		var id: String = java.util.UUID.randomUUID().toString();
		var stream: ByteArrayOutputStream = QRCode.from(id).to(ImageType.PNG).withSize(250, 250).stream();
		return stream.toByteArray();
	}

	def main(args: Array[String]) {
		// test
		println(generate());

		var out: FileOutputStream = new FileOutputStream(new File("target/label" + args(0) + ".png"));
		IOUtils.write(generate(), out);
		out.close();

	}

}