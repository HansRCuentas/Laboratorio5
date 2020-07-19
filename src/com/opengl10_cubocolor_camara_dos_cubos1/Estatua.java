package com.opengl10_cubocolor_camara_dos_cubos1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Estatua {
	/**
	 * 3 --------- 2 /| /| / | / | 7 --------- 6 | | | | | | 0 ------|-- 1 | / |
	 * / |/ |/ 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			// Frente
			-1, -1, 0, // 2 0
			0, 0, 2, // 4 1
			1, -1, 0, // 3 2
			// Atrás
			-1, 1, 0, // 0 3
			1, 1, 0, // 1 4
			0, 0,2, // 4 5
			// Izquierda
			-1, 1, 0, // 0 6
			-1, -1, 0, // 2 7
			0, 0, 2, // 4 8
			// Derecha
			1, 1, 0, // 1 9
			1, -1, 0, // 3 10
			0, 0, 2, // 4 11
			// ABAAAAAJOOOOOO
			// Frente
			-1, -1, 0, // 2 12
			0, 0, -2, // 4 13
			1, -1, 0, // 3 14
			// Atrás
			-1, 1, 0, // 0 15
			1, 1, 0, // 1 16
			0, 0, -2, // 4 17
			// Izquierda
			-1, 1, 0, // 0 18
			-1, -1, 0, // 2 19
			0, 0, -2, // 4 20
			// Derecha
			1, 1, 0, // 1 21
			1, -1, 0, // 3 22
			0, 0, -2 // 4 23			

	};
	/* Los colores x c/vértice (r,g,b,a) */
	byte maxColor = (byte) 255;
	private byte colores[] = new byte[] {
			// Frente - lila
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Atrás - amarillo
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Izquierda - celeste
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Derecha - rojo
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Frente - lila
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Atrás - amarillo
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Izquierda - celeste
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			// Derecha - rojo
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1, // 3
			(byte)238, (byte)238, (byte)238, 1 // 3
	};
	/* Indices */
	private short indices[] = new short[] { 
			0, 1, 2,  // Frente
			3, 4, 5,  // Atrás
			6, 7, 8, // Izquierda
			9, 10, 11,  // Derecha
			12,13,14,
			15,16,17,
			18,19,20,
			21,22,23
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Estatua() {
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
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
		/* Se dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso a los arreglos */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
