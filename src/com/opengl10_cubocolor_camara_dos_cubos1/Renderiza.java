package com.opengl10_cubocolor_camara_dos_cubos1;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.view.MotionEvent;
public class Renderiza extends GLSurfaceView implements Renderer {
	/* Objeto */
	private Casa casa;
	private Superficie base;
	private Parque parque;
	private Circulos ciculos;
	private Cubo cubo;
	private Barras barra;
	private Arbol arbol;
	private Jardin jardin;
	private Jardin2 jardin2;
	private Cancha cancha;
	private Gradas gradas;
	private Puerta puerta;
	private Puerta1 puerta1;
	private Puerta2 puerta2;
	private Piscina piscina;
	private Piscina2 piscina2;
	private Circulos circulop1;
	private Circulos circulop2;
	private Estatua estatua;
	private Circulo circulo,circulo2,circulo3;
	private Esfera esfera;
	private Esfera balon;
	/* Inicializa ubicación de la vista del observador */
	private final float[] vectorEntrada = { 0, 0, -1, 1 };
	private static float posicion[] = { 0, 0, 0.f };
	private final float[] direccion = new float[4];

	/* Tamaño de la ventana en pixeles */
	private int alto;
	private int ancho;

	/* Para la rotación y traslación */
	private float rotY;
	private	float antX;

	final float[] matriz = new float[16];

	/* Contexto */
	Context contexto;

	public Renderiza(Context contexto) {
		super(contexto);
		this.contexto = contexto;
		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
	
		
		esfera = new Esfera(1f, 10, 10);
		balon = new Esfera(0.2f, 10, 10);
		circulo = new Circulo(0.5f, 360, true);
		circulo2 = new Circulo(10, 360, true);
		circulo3 = new Circulo(16.5f, 360, true);
		base = new Superficie();
		casa =new Casa();		
		parque = new Parque();
		cubo = new Cubo();
		barra=new Barras();
		arbol=new Arbol();
		ciculos = new Circulos(5, 360, true);
		jardin = new Jardin();
		jardin2 = new Jardin2();
		cancha=new Cancha();
		gradas=new Gradas();		
		puerta=new Puerta();
		puerta1=new Puerta1();
		puerta2=new Puerta2();
		piscina=new Piscina();
		piscina2=new Piscina2();
		circulop1=new Circulos(4,360,true);
		circulop2=new Circulos(5,360,true);
		estatua= new Estatua();
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(176/255f, 196/255f, 222/256f, 0);
	}
	@Override
	public void onDrawFrame(GL10 gl) {

		/* Borra el buffer de la ventana y del z-buffer */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		/* Botones de las opciones */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(  -4, 4, -6, 6, 1, 100);
		//
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		// Botón avanza
		gl.glPushMatrix();
		gl.glColor4f(0, 0, 1, 0);
		gl.glTranslatef(0, -4, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();

		// Botón retrocede
		gl.glPushMatrix();
		gl.glColor4f(0, 0, 1, 0);
		gl.glTranslatef(0, -5.5f, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();

		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 100, ancho / (float)alto, 1f, 100f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glRotatef(-rotY, 0, 1, 0);
		gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);

		// Piso
		gl.glPushMatrix();
		gl.glTranslatef(0, -2f, 0);
		gl.glRotatef(270, 90, 0, 1);
		//gl.glScalef(0.1f, 0.1f, 0.1f);
		base.dibuja(gl);
		gl.glPopMatrix();
		//
		
		gl.glPushMatrix();
		gl.glTranslatef(15, -2,12 );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1.5f, 2, 1);
		casa.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(15, -2,1 );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1, 1, 2);
		casa.dibuja(gl);
		gl.glPopMatrix();
		

		
		
		//PAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEED IZQUIEEEEEEERDAA
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 29); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 25); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 21); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 17); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 13);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 9); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 5); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, 1); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1.9f, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();


		//fila1
		
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, 21);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, 13);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();					
		
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, -1, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();	
		
		//fila2
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, 17);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, 9);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 0, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila3
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, 21);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, 13);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 1, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		//fila4
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, 17);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, 9);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 2, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila5
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, 21);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, 13);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, 5); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, -3); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 3, -27); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		//fila6
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, 17);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, 9);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 4, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila 7
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 21);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 17);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 13);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29,5, 9); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-29, 5, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		//PAREEEEEEEEEEEEEEEEEEEEEEEEED ABAJOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		gl.glPushMatrix();	gl.glTranslatef(-28, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, -1.9f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		
		//Fila 1
		gl.glPushMatrix();	gl.glTranslatef(-28, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();


		gl.glPushMatrix();	gl.glTranslatef(3, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, -1f, 30);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		
		
		//PAREEEEEEEEEEEEEEEEEEEEEEEEEED ARRRRIBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		gl.glPushMatrix();	gl.glTranslatef(-28, -1.9f,-29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, -1.9f, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//1 FILA
		gl.glPushMatrix();	gl.glTranslatef(-28, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, -1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//2 FILA
		gl.glPushMatrix();	gl.glTranslatef(-28, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 0, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 0,-29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//3 FILA
		gl.glPushMatrix();	gl.glTranslatef(-28, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 1, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//4 FILA 
		gl.glPushMatrix();	gl.glTranslatef(-28, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 2, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//5 FIL
		gl.glPushMatrix();	gl.glTranslatef(-28, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 3, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//6 FILA
		gl.glPushMatrix();	gl.glTranslatef(-28, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 4, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		//7 FILA
		gl.glPushMatrix();	gl.glTranslatef(-28, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-25, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-21, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-17, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-13, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-9, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-5, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(-1, 5, -29); gl.glRotatef(270, 90, 0, 1);jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(3, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(7, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(11, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(15, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(19, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(23, 5,-29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(27, 5, -29);gl.glRotatef(270, 90, 0, 1); jardin.dibuja(gl);gl.glPopMatrix();

		//PAREEEEEEEEEEEEEEEEEEEEEED DERECHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f,-3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -7); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1.9f, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();

		//fila1
		
		gl.glPushMatrix();	gl.glTranslatef(29, -1, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, -1, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();					
		
		gl.glPushMatrix();	gl.glTranslatef(29, -1, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, -1, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();	
		
		//fila2
		gl.glPushMatrix();	gl.glTranslatef(29, 0, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 0, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 0, -7); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 0, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 0, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila3
		
		gl.glPushMatrix();	gl.glTranslatef(29, 1, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 1, 5); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 1, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 1,-11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 1,-19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 1,-27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		//fila4
		gl.glPushMatrix();	gl.glTranslatef(29, 2, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 2, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 2, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 2, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 2, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila5
		gl.glPushMatrix();	gl.glTranslatef(29, 3, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 3, 5);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 3, -3); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 3, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 3, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 3, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila6
		gl.glPushMatrix();	gl.glTranslatef(29, 4, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
	
		gl.glPushMatrix();	gl.glTranslatef(29, 4, 1);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 4, -7);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 4, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 4, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//fila 7
		gl.glPushMatrix();	gl.glTranslatef(29, 5, 29);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, 25);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//gl.glPushMatrix();	gl.glTranslatef(29, -21, 7f); jardin2.dibuja(gl);gl.glPopMatrix();
		//gl.glPushMatrix();	gl.glTranslatef(29, -17, 7f); jardin2.dibuja(gl);gl.glPopMatrix();
		//gl.glPushMatrix();	gl.glTranslatef(29, -13, 7f); jardin2.dibuja(gl);gl.glPopMatrix();
		//gl.glPushMatrix();	gl.glTranslatef(29, -9, 7f); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, 5); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, 1); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -3);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -7); gl.glRotatef(270, 90, 0, 1);jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -11);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -15);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -19);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -23);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(29, 5, -27);gl.glRotatef(270, 90, 0, 1); jardin2.dibuja(gl);gl.glPopMatrix();
		//PUEEEEEEEEEEEEEEEEEEEEEERTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		gl.glPushMatrix();	gl.glTranslatef(30, 6, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 6, 1);puerta.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 5, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta1.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 4, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 3, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta1.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 2, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta1.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 1, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, 0, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta1.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, -1,15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta2.dibuja(gl);gl.glPopMatrix();
		gl.glPushMatrix();	gl.glTranslatef(30, -1.9f, 15);gl.glRotatef(270, 90, 0, 1);gl.glScalef(2, 4, 1);puerta1.dibuja(gl);gl.glPopMatrix();
					
		//
		//ARBOLIIIIIIIIIIIIIIIIIIIIIIIIIITOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOS
		//aRRIBA
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, -25);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-22, 0, -25);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-18, 0, -25);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();			
		gl.glTranslatef(-14, 0, -25);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, -21);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, -17);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, -13);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		//AAAAAAAAAAABAJOO
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-22, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-18, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, 23);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-26, 0, 19);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		//ABAAAAAAAJOOOOOOO DERECHAAA
		gl.glPushMatrix();			
		gl.glTranslatef(26, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(22, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(18, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(14, 0, 27);
		gl.glRotatef(270, 90, 0, 1);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		//PARQUEEEEESIIIITOOO
		gl.glPushMatrix();			
		gl.glTranslatef(-25, 0.5f-2,2 );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1.5f, 1.5f, 1.5f);
		parque.dibuja(gl);
		gl.glPopMatrix();		
		gl.glPushMatrix();			
		gl.glTranslatef(-17,0.2f-2 , 2);
		gl.glRotatef(270, 90, 0, 1);
		gl.glColor4f(247/255f, 248/255f, 71/255f, 0);
		ciculos.dibuja(gl);
		gl.glPopMatrix();			
		//PISCIIIIIIIIIIINAAAAAAAAAAAAAA
		gl.glPushMatrix();
		gl.glTranslatef(2, -1.6f,9f );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1, 1, 1);
		piscina.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(2, -1.8f,9f );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1, 1, 1);
		piscina2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-6, -1.5f, 2f);
		gl.glRotatef(270, 90, 0, 1);
		parque.dibuja(gl);
		gl.glPopMatrix();	
		//Pisina2
		gl.glPushMatrix();			
		gl.glTranslatef(2,-1.4f , 21f);
		gl.glRotatef(270, 90, 0, 1);
		gl.glColor4f(20/255f, 222/255f, 222/255f, 0);
		circulop1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(2,-1.5f , 21f);
		gl.glRotatef(270, 90, 0, 1);
		gl.glColor4f(138/255f, 138/255f, 138/255f, 0);
		circulop2.dibuja(gl);
		gl.glPopMatrix();
		

		
		
		
		//Estatuaaa
		
		gl.glPushMatrix();			
		gl.glTranslatef(-18,-1.2f , -17f);
		gl.glRotatef(270, 90, 0, 1);
		gl.glColor4f(20/255f, 222/255f, 222/255f, 0);
		circulop1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(-18,-1.5f , -17f);
		gl.glRotatef(270, 90, 0, 1);
		gl.glColor4f(138/255f, 138/255f, 138/255f, 0);
		circulop2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		
		gl.glTranslatef(-18, 1,-17 );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1.5f, 1.5f, 1);
		estatua.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-18, 4,-17 );
		gl.glRotatef(270, 90, 0, 1);
		gl.glScalef(1.5f, 1.5f, 1);
		esfera.dibuja(gl);
		gl.glPopMatrix();
	
		//CUBOOOOOS	
		gl.glPushMatrix();
		gl.glColor4f(26/255f, 138/255f, 19/255f, 0);
		gl.glTranslatef(-9, -0.95f, 10);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(26/255f, 138/255f, 19/255f, 0);
		gl.glTranslatef(-9, -0.95f, 14);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(26/255f, 138/255f, 19/255f, 0);
		gl.glTranslatef(-9, -0.95f, 18);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		//amarillo
		gl.glPushMatrix();			
		gl.glColor4f(1, 1, 0, 0);
		gl.glTranslatef(-9, 1.05f, 12);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(1, 1,0, 0);
		gl.glTranslatef(-9, 1.05f, 16);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(1, 0,0, 0);
		gl.glTranslatef(-9, 3.05f, 14);
		gl.glRotatef(270, 90, 0, 1);
		cubo.dibuja2(gl);
		gl.glPopMatrix();
		
		
	gl.glPushMatrix();			
	gl.glColor4f(1, 0,0, 0);
	gl.glTranslatef(-10, -2f, 27f);
	gl.glRotatef(270, 90, 0, 1);
	barra.dibuja(gl);
	gl.glPopMatrix();
	
	
	
	//cancha
	gl.glPushMatrix();			
	gl.glTranslatef(8, -1.8f, -17f);
	gl.glRotatef(270, 90, 0, 1);
	cancha.dibuja(gl);
	gl.glPopMatrix();
	
	gl.glPushMatrix();
	gl.glColor4f(0/255f, 73/255f,147/255f, 0);
	gl.glTranslatef(13, -1.5f,-17 );
	gl.glRotatef(270, 90, 0, 1);
	gl.glScalef(1.5f, 1.5f, 1);
	balon.dibuja(gl);
	gl.glPopMatrix();
	
	//gradas y Derecha
	
	gl.glPushMatrix();			
	gl.glTranslatef(25, -1.9f, -17f);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();
	
	gl.glPushMatrix();			
	gl.glTranslatef(26, -0.9f, -17f);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();

	gl.glPushMatrix();			
	gl.glTranslatef(27, 0.1f, -17f);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();

	gl.glPushMatrix();			
	gl.glTranslatef(27, -1, -17f);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();
	gl.glPushMatrix();			
	gl.glTranslatef(27, -2, -17f);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();
	
	//Gradas Y Izq
	
	gl.glPushMatrix();			
	gl.glTranslatef(-9, -1.9f, -17);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();
	
	gl.glPushMatrix();			
	gl.glTranslatef(-10, -0.9f, -17);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();

	gl.glPushMatrix();			
	gl.glTranslatef(-10, -1.9f, -17);
	gl.glRotatef(270, 90, 0, 1);
	gradas.dibuja(gl);
	gl.glPopMatrix();


		//gl.glFlush();

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		ancho = w;
		alto = h;
		gl.glViewport(0, 0, ancho, alto);
		GLU.gluLookAt(gl, 0, 0, 0, -0.1f, 0, 1, 0, 0, 2);

	}

	/**
	 * Maneja los eventos del movimiento en la pantalla táctil. 
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {

		/* Obtiene la coordenada de la pantalla */
		float posx = e.getX();
		float posy = e.getY();

		/* Se considera cuando se levanta el dedo de la pantalla. */ 
		if (e.getAction() == MotionEvent.ACTION_DOWN) {

			/* En coordenadas del OpenGL */
			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 12) - 6;

			/* Verifica área elegida */
			if (puntoEstaDentroDelCirculo(posx, posy, 0, -4f, 0.6f)) { // Avanza
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);

				posicion[0] = posicion[0] + direccion[0] * 0.845f;
				posicion[1] = posicion[1] + direccion[1] * 0.845f;
				posicion[2] = posicion[2] + direccion[2] * 0.845f;

			} else if (puntoEstaDentroDelCirculo(posx, posy, 0, -5.5f, 0.6f)) { // Retrocede
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);

				posicion[0] = posicion[0] - direccion[0] * 0.81f;
				posicion[1] = posicion[1] - direccion[1] * 0.81f;
				posicion[2] = posicion[2] - direccion[2] * 0.81f;
			}
			requestRender();
		} else if (e.getAction() == MotionEvent.ACTION_MOVE) {
			if(antX == -1) {
				antX = posx;
			} else {							
				rotY = rotY + (posx - antX) / 10;
				antX = posx;
			}

			requestRender();
		} else { 
			antX = -1;
		}	
		return true;
	}

	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
