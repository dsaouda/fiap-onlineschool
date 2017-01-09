package br.com.fiap.dsaouda.javaweb.main;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Test {
	public static void main(String[] args) {
		Parser parser = Parser.builder().build();
		Node document = parser.parse(" - Teste");
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		System.out.println(renderer.render(document));
	}
}
