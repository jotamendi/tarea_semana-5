package com.jmdevs.petagram.db;

public final class constantesBaseDatos {
    public static final String DATABASE_NAME    = "mascotas";
    public static final int DATBASE_VERSION     = 1;

    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "pet_id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "pic";

    public static final String TABLE_POSTS              = "posts";
    public static final String TABLE_POSTS_ID           = "id_post";
    public static final String TABLE_POSTS_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_POSTS_RATE         = "rate";
    public static final String TABLE_POSTS_POST         = "pic_post";
    public static final String TABLE_POSTS_LIKED        = "liked";

    public static final String TABLE_5FAVS              = "last5favs";
    public static final String TABLE_5FAVS_POST_ID      = "id_post";
    public static final String TABLE_5FAVS_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_5FAVS_POST_RATE    = "rate";
    public static final String TABLE_5FAVS_POST         = "pic_post";
    public static final String TABLE_5FAVS_LIKED        = "liked";
    public static final String TABLE_5FAVS_ORD          = "orden";
}
