package com.dellux.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("biWriter")
public class BookItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> chunk) throws Exception {
		System.out.println("BookItemWriter.write()");
		chunk.forEach(book->{
			System.out.println(book);
		});
	}
	/*
	 * @Override public void write(List<? extends String> items) throws Exception {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
