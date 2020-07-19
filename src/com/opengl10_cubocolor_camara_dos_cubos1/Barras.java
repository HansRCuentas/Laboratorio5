package com.opengl10_cubocolor_camara_dos_cubos1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
	public class Barras {
		/* Coordenadas cartesianas (x, y, z) */
		private float vertices[] = new float[] {
				4, 1, 0, // 0 a
				4, 1, 7, // 1 b
				4, 4, 0, // 2 c
				4, 4, 7, // 3 d
				-4,1, 0, // 4 e
				-4, 1, 7, // 5 f
				-4, 4, 0, // 6 g
				-4, 4, 7, // 7 h
				
				4, 1, 0.6f, // 8 a
				4, 4, 0.6f, // 9 c
				
				4, 1, 1.2f, // 10 a
				4, 4, 1.2f, // 11 c
				
				4, 1, 1.8f, // 12 a
				4, 4, 1.8f, // 13 c
				
				-4, 1, 0.6f, // 14 a
				-4, 4, 0.6f, // 15 c
				
				-4, 1, 1.2f, // 16 a
				-4, 4, 1.2f, // 17 c
				
				-4, 1, 1.8f, // 18 a
				-4, 4, 1.8f, // 19 c
				//barras arriba
				2, 1, 7, // 20
				2, 4, 7, // 21 d
				
				0, 1, 7, // 22 b
				0, 4, 7, // 23 d
				
				-2, 1, 7, // 24 b
				-2, 4, 7, // 25 d
				//fondos
				-12,4,0,	//26i
				-12,4,5, 	//27k
				-9,4,5,		//28l
				-9,4,0,		//29j
				
				-12,14,0,	//20i
				-12,14,5, 	//31k
				-9,14,5,		//32l
				-9,14,0,		//33j
				
				-12,3.52f,5, 	//34k
				-9,3.52f,5,		//35l
				-12,14.8f,5, 	//36k
				-9,14.8f,5,		//37l
				//dominadas
				-3,18,0,	//38
				-3,18,7f,	//39
				-7,18,7,	//40
				-7,18,0,	//41
				-7,18,9,	//42
				-11,18,9,	//43
				-11,18,0,	//44
				-11,18,5,	//45
				-15,18,5,	//46
				-15,18,0,	//47
		};
		/* Indices */
		private short indices[] = new short [] {
				0,1,1,3,3,2, // Frente
				1,5,5,7,7,3,3,1,
				6,7,7,5,5,4,
				8,9,10,11,12,13,
				14,15,16,17,18,19,
				20,21,22,23,24,25,
				//barra fondos
				26,27,28,29,
				30,31,32,33,
				34,36,35,37,
				//dominadas
				38,39,39,40,40,41,
				41,42,42,43,43,44,
				44,45,45,46,46,47,
		};
		private FloatBuffer bufVertices;
		private ShortBuffer bufIndices;
		public Barras() {
			/* Lee los vértices */
			ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
			bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
			bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
			bufVertices.put(vertices);
			bufVertices.rewind(); // puntero al principio del buffer
			//OpenGL ES 1.x – Cubo Malla Cuadrado 5 Lic. J. Felipez
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
			/* Se especifica los datos del arreglo de vértices */
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
			/* Se establece el color en (r,g,b,a) */
			gl.glColor4f(1, 0, 0, 0);
			gl.glLineWidth(5);
			/* Dibuja el cubo */
			gl.glDrawElements(GL10.GL_LINES, indices.length,
					GL10.GL_UNSIGNED_SHORT, bufIndices);
			/* Se deshabilita el acceso al arreglo de vértices */
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

	}

