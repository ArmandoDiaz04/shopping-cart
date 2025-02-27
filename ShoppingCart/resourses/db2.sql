PGDMP      4                 }            postgres    17.2    17.2 2    g           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            h           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            i           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            j           1262    5    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_El Salvador.1252';
    DROP DATABASE postgres;
                     postgres    false            k           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                        postgres    false    4970                        2615    16387    ecomm    SCHEMA        CREATE SCHEMA ecomm;
    DROP SCHEMA ecomm;
                     postgres    false            �            1259    16388    authorization    TABLE     �   CREATE TABLE ecomm."authorization" (
    id uuid NOT NULL,
    authorized boolean,
    error character varying(250),
    message character varying,
    "time" timestamp without time zone,
    order_id uuid NOT NULL
);
 "   DROP TABLE ecomm."authorization";
       ecomm         heap r       postgres    false    6            �            1259    16393    card    TABLE     �   CREATE TABLE ecomm.card (
    card_id uuid NOT NULL,
    cvv character varying(10),
    expires character varying(10),
    number character varying(50),
    user_id uuid NOT NULL
);
    DROP TABLE ecomm.card;
       ecomm         heap r       postgres    false    6            �            1259    16396    cart    TABLE     R   CREATE TABLE ecomm.cart (
    cart_id uuid NOT NULL,
    user_id uuid NOT NULL
);
    DROP TABLE ecomm.cart;
       ecomm         heap r       postgres    false    6            �            1259    16399 	   cart_item    TABLE     Z   CREATE TABLE ecomm.cart_item (
    cart_id uuid NOT NULL,
    item_id integer NOT NULL
);
    DROP TABLE ecomm.cart_item;
       ecomm         heap r       postgres    false    6            �            1259    16402    item    TABLE     �   CREATE TABLE ecomm.item (
    unit_price numeric(19,2),
    quantity integer,
    product_id integer NOT NULL,
    item_id integer NOT NULL
);
    DROP TABLE ecomm.item;
       ecomm         heap r       postgres    false    6            �            1259    16405    item_item_id_seq    SEQUENCE     �   CREATE SEQUENCE ecomm.item_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE ecomm.item_item_id_seq;
       ecomm               postgres    false    222    6            l           0    0    item_item_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE ecomm.item_item_id_seq OWNED BY ecomm.item.item_id;
          ecomm               postgres    false    223            �            1259    16406    order    TABLE     �   CREATE TABLE ecomm."order" (
    order_id uuid NOT NULL,
    order_date timestamp without time zone,
    status character varying(50),
    total numeric(19,2),
    card_id uuid,
    payment_id uuid,
    customer_id uuid
);
    DROP TABLE ecomm."order";
       ecomm         heap r       postgres    false    6            �            1259    16409 
   order_item    TABLE     i   CREATE TABLE ecomm.order_item (
    id uuid NOT NULL,
    order_id uuid,
    item_id integer NOT NULL
);
    DROP TABLE ecomm.order_item;
       ecomm         heap r       postgres    false    6            �            1259    16412    payment    TABLE     y   CREATE TABLE ecomm.payment (
    payment_id uuid NOT NULL,
    authorized boolean,
    message character varying(250)
);
    DROP TABLE ecomm.payment;
       ecomm         heap r       postgres    false    6            �            1259    16415    user    TABLE     b  CREATE TABLE ecomm."user" (
    user_id uuid NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100),
    phone character varying(10),
    email character varying(100),
    username character varying(20),
    password character varying(250),
    role character varying(25),
    user_status character varying(20)
);
    DROP TABLE ecomm."user";
       ecomm         heap r       postgres    false    6            �            1259    16420 
   user_token    TABLE     }   CREATE TABLE ecomm.user_token (
    id uuid NOT NULL,
    refresh_token character varying(200),
    user_id uuid NOT NULL
);
    DROP TABLE ecomm.user_token;
       ecomm         heap r       postgres    false    6            �           2604    16497    item item_id    DEFAULT     j   ALTER TABLE ONLY ecomm.item ALTER COLUMN item_id SET DEFAULT nextval('ecomm.item_item_id_seq'::regclass);
 :   ALTER TABLE ecomm.item ALTER COLUMN item_id DROP DEFAULT;
       ecomm               postgres    false    223    222            Z          0    16388    authorization 
   TABLE DATA           Z   COPY ecomm."authorization" (id, authorized, error, message, "time", order_id) FROM stdin;
    ecomm               postgres    false    218   !:       [          0    16393    card 
   TABLE DATA           E   COPY ecomm.card (card_id, cvv, expires, number, user_id) FROM stdin;
    ecomm               postgres    false    219   >:       \          0    16396    cart 
   TABLE DATA           /   COPY ecomm.cart (cart_id, user_id) FROM stdin;
    ecomm               postgres    false    220   �:       ]          0    16399 	   cart_item 
   TABLE DATA           4   COPY ecomm.cart_item (cart_id, item_id) FROM stdin;
    ecomm               postgres    false    221   P;       ^          0    16402    item 
   TABLE DATA           H   COPY ecomm.item (unit_price, quantity, product_id, item_id) FROM stdin;
    ecomm               postgres    false    222   m;       `          0    16406    order 
   TABLE DATA           g   COPY ecomm."order" (order_id, order_date, status, total, card_id, payment_id, customer_id) FROM stdin;
    ecomm               postgres    false    224   �;       a          0    16409 
   order_item 
   TABLE DATA           :   COPY ecomm.order_item (id, order_id, item_id) FROM stdin;
    ecomm               postgres    false    225   �<       b          0    16412    payment 
   TABLE DATA           A   COPY ecomm.payment (payment_id, authorized, message) FROM stdin;
    ecomm               postgres    false    226   �=       c          0    16415    user 
   TABLE DATA           t   COPY ecomm."user" (user_id, first_name, last_name, phone, email, username, password, role, user_status) FROM stdin;
    ecomm               postgres    false    227   �=       d          0    16420 
   user_token 
   TABLE DATA           ?   COPY ecomm.user_token (id, refresh_token, user_id) FROM stdin;
    ecomm               postgres    false    228   �>       m           0    0    item_item_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('ecomm.item_item_id_seq', 10, true);
          ecomm               postgres    false    223            �           2606    16425    authorization authorized_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY ecomm."authorization"
    ADD CONSTRAINT authorized_pk PRIMARY KEY (id);
 F   ALTER TABLE ONLY ecomm."authorization" DROP CONSTRAINT authorized_pk;
       ecomm                 postgres    false    218            �           2606    16427    card card_pk 
   CONSTRAINT     N   ALTER TABLE ONLY ecomm.card
    ADD CONSTRAINT card_pk PRIMARY KEY (card_id);
 5   ALTER TABLE ONLY ecomm.card DROP CONSTRAINT card_pk;
       ecomm                 postgres    false    219            �           2606    16429    cart cart_pk 
   CONSTRAINT     N   ALTER TABLE ONLY ecomm.cart
    ADD CONSTRAINT cart_pk PRIMARY KEY (cart_id);
 5   ALTER TABLE ONLY ecomm.cart DROP CONSTRAINT cart_pk;
       ecomm                 postgres    false    220            �           2606    16431    user customer_pk 
   CONSTRAINT     T   ALTER TABLE ONLY ecomm."user"
    ADD CONSTRAINT customer_pk PRIMARY KEY (user_id);
 ;   ALTER TABLE ONLY ecomm."user" DROP CONSTRAINT customer_pk;
       ecomm                 postgres    false    227            �           2606    16433    item item_pk 
   CONSTRAINT     N   ALTER TABLE ONLY ecomm.item
    ADD CONSTRAINT item_pk PRIMARY KEY (item_id);
 5   ALTER TABLE ONLY ecomm.item DROP CONSTRAINT item_pk;
       ecomm                 postgres    false    222            �           2606    16435    user_token newtable_pk 
   CONSTRAINT     S   ALTER TABLE ONLY ecomm.user_token
    ADD CONSTRAINT newtable_pk PRIMARY KEY (id);
 ?   ALTER TABLE ONLY ecomm.user_token DROP CONSTRAINT newtable_pk;
       ecomm                 postgres    false    228            �           2606    16437    order_item order_item_pk 
   CONSTRAINT     U   ALTER TABLE ONLY ecomm.order_item
    ADD CONSTRAINT order_item_pk PRIMARY KEY (id);
 A   ALTER TABLE ONLY ecomm.order_item DROP CONSTRAINT order_item_pk;
       ecomm                 postgres    false    225            �           2606    16439    order order_pk 
   CONSTRAINT     S   ALTER TABLE ONLY ecomm."order"
    ADD CONSTRAINT order_pk PRIMARY KEY (order_id);
 9   ALTER TABLE ONLY ecomm."order" DROP CONSTRAINT order_pk;
       ecomm                 postgres    false    224            �           2606    16441    payment payment_pk 
   CONSTRAINT     W   ALTER TABLE ONLY ecomm.payment
    ADD CONSTRAINT payment_pk PRIMARY KEY (payment_id);
 ;   ALTER TABLE ONLY ecomm.payment DROP CONSTRAINT payment_pk;
       ecomm                 postgres    false    226            �           2606    16442    authorization authorized_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm."authorization"
    ADD CONSTRAINT authorized_fk FOREIGN KEY (order_id) REFERENCES ecomm."order"(order_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 F   ALTER TABLE ONLY ecomm."authorization" DROP CONSTRAINT authorized_fk;
       ecomm               postgres    false    224    4789    218            �           2606    16447    card card_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.card
    ADD CONSTRAINT card_fk FOREIGN KEY (user_id) REFERENCES ecomm."user"(user_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 5   ALTER TABLE ONLY ecomm.card DROP CONSTRAINT card_fk;
       ecomm               postgres    false    227    219    4795            �           2606    16452    cart cart_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.cart
    ADD CONSTRAINT cart_fk FOREIGN KEY (user_id) REFERENCES ecomm."user"(user_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 5   ALTER TABLE ONLY ecomm.cart DROP CONSTRAINT cart_fk;
       ecomm               postgres    false    220    4795    227            �           2606    16457    cart_item cart_item_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.cart_item
    ADD CONSTRAINT cart_item_fk FOREIGN KEY (cart_id) REFERENCES ecomm.cart(cart_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 ?   ALTER TABLE ONLY ecomm.cart_item DROP CONSTRAINT cart_item_fk;
       ecomm               postgres    false    4785    221    220            �           2606    16462    cart_item cart_item_fk2    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.cart_item
    ADD CONSTRAINT cart_item_fk2 FOREIGN KEY (item_id) REFERENCES ecomm.item(item_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 @   ALTER TABLE ONLY ecomm.cart_item DROP CONSTRAINT cart_item_fk2;
       ecomm               postgres    false    222    4787    221            �           2606    16467    order order_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm."order"
    ADD CONSTRAINT order_fk FOREIGN KEY (card_id) REFERENCES ecomm.card(card_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 9   ALTER TABLE ONLY ecomm."order" DROP CONSTRAINT order_fk;
       ecomm               postgres    false    219    224    4783            �           2606    16472    order order_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm."order"
    ADD CONSTRAINT order_fk_1 FOREIGN KEY (payment_id) REFERENCES ecomm.payment(payment_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 ;   ALTER TABLE ONLY ecomm."order" DROP CONSTRAINT order_fk_1;
       ecomm               postgres    false    226    224    4793            �           2606    16477    order order_fk_2    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm."order"
    ADD CONSTRAINT order_fk_2 FOREIGN KEY (customer_id) REFERENCES ecomm."user"(user_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 ;   ALTER TABLE ONLY ecomm."order" DROP CONSTRAINT order_fk_2;
       ecomm               postgres    false    227    224    4795            �           2606    16482    order_item order_item_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.order_item
    ADD CONSTRAINT order_item_fk FOREIGN KEY (item_id) REFERENCES ecomm.item(item_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 A   ALTER TABLE ONLY ecomm.order_item DROP CONSTRAINT order_item_fk;
       ecomm               postgres    false    222    225    4787            �           2606    16487    order_item order_item_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.order_item
    ADD CONSTRAINT order_item_fk_1 FOREIGN KEY (order_id) REFERENCES ecomm."order"(order_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 C   ALTER TABLE ONLY ecomm.order_item DROP CONSTRAINT order_item_fk_1;
       ecomm               postgres    false    225    4789    224            �           2606    16492    user_token user_token_fk    FK CONSTRAINT     �   ALTER TABLE ONLY ecomm.user_token
    ADD CONSTRAINT user_token_fk FOREIGN KEY (user_id) REFERENCES ecomm."user"(user_id) ON UPDATE CASCADE ON DELETE RESTRICT;
 A   ALTER TABLE ONLY ecomm.user_token DROP CONSTRAINT user_token_fk;
       ecomm               postgres    false    227    4795    228            Z      x������ � �      [   �   x����q1г�6P.{�(�<�vnE�+�)ϙ����As+dj�$s�˃��	7�_F�f��Fha���&�(�W�%b�'��	If���Ym5�g�	��b(E��c�+�(`�AP�	���}W\R��4G#|m����b��5��r�D�����S�@û�{�:�0�??��?�a�      \   B   x�KNLNL26L�M57N�5144�ML3O�M2�056H3�022�L4L�$��+��I&Ęd����� �
&]      ]      x������ � �      ^   H   x�-��� Cѳ=L�CR`��?G��[y��PG���fkUO��^�kb+�=��a�q����|��)�:      `   �   x���=N1�z�\�#�qg:�R �m���d$�@4ۤ�ާ�ȡ8g�h�M�SB���|n��@h/X�D'ӡR�������u{�����Ex���31pʊ4�pn��csj�%0K� D��V�	#3��x���[[!�`�&�5tb�G��E[)%~&����5���|.��4�@�ə�0&�O�6��n�֯^��eѤ�+���N��Af��Fא�u_���)���~?�}�����      a   �   x��λ�1DQ{���#rYG"�vB���E�(C�Π���s#�IO�N���A���*B��"���C�*��6(2����K[��/�y�%�����ЮT�.k�`�(�2�7��>|�t��
P�����JέJ���x�a�)��Y�Z��3��i�� b�l�@p��j�����1�Ms]�      b   A   x�3037O150�5�03�5107ֵHN1�5573J30J60���,�p��u�Qpvr����� v��      c   �   x���Kk�0�ϫ�"c��nvhuR'���ʒK��!
��r[h/�0�2��C�i'�硒#WB ���+�B擬%l/�C�\���h�[|d��198�y�/����-�MV��	�������#��k��YBw�wP���Κ��7�!kW=�X0�*�t�����V��W�5ס�xeI#�̅���-8�Z�RV5��o��txI��gl7���b��1�a;h�      d      x������ � �     