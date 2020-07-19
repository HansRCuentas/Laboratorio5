package com.opengl10_cubocolor_camara_dos_cubos1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Jardin2{
	private float vertices[] = new float [] {
			0.6f,-2f,0,
			0.6f,-2f,1,
			0.6f,2f,1,
			0.6f,2f,0,
			-0.6f,-2f,0,
			-0.6f,-2f,1,
			-0.6f,2f,1,
			-0.6f,2f,0,
			
			0.5f,-2f,1,
			-0.5f,-2f,1,
			-0.5f,2f,1,
			0.5f,2f,1,
			
			0.5f,2f,0,
			0.5f,2f,1,
			-0.5f,2f,1,
			-0.5f,2f,0,
			
			-0.5f,-2f,0,
			-0.5f,-2f,1,
			0.5f,-2f,1,
			0.5f,-2f,0,
			
			
	};

	byte maxColor = (byte)255;
	
	/* Los colores x c/vértice (r,g,b,a) */
	private byte colores[] = new byte[] { 
			//base
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
			
				
			(byte)23, (byte)203, (byte)4, 1, // 0
			(byte)23, (byte)203, (byte)4, 1, // 0
			(byte)23, (byte)203, (byte)4, 1, // 0
			(byte)23, (byte)203, (byte)4, 1, // 0
			
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
			(byte)52, (byte)177, (byte)39, 1, // 0
		
			
			(byte)28, (byte)127, (byte)12, 1, // 0
			(byte)28, (byte)127, (byte)12, 1, // 0
			(byte)28, (byte)127, (byte)12, 1, // 0
			(byte)28, (byte)127, (byte)12, 1, // 0
			
			(byte)27, (byte)107, (byte)19, 1, // 0
			(byte)27, (byte)107, (byte)19, 1, // 0
			(byte)27, (byte)107, (byte)19, 1, // 0
			(byte)27, (byte)107, (byte)19, 1, // 0
			
	};
	

	
	/* Indices */
	private short indices[] = new short [] {
			//base
			0,1,2,0,2,3,
			4,5,6,4,6,7,
			8,9,10,8,10,11,
			12,13,14,12,14,15,
			16,17,18,16,18,19,
			
	};
	
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public Jardin2() {
		
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
		
	}
	
	public void dibuja(GL10 gl) {
		
		/* Se habilita el acceso al arreglo de vértices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		/* Se especifica los datos del arreglo de vértices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);

		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);

		/* Renderiza las primitivas desde los datos de los arreglos (vértices,
		 * colores e índices) */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);

		/* Se deshabilita el acceso al arreglo de vértices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		//* Se deshabilita el acceso al arreglo de colores */
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}
}
