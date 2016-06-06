package dev.parcs.game.graphics.image;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage[] bullet, playerLeft, playerRight, deathRayWep, explode, enemyBullet, bulletHead;
    public static BufferedImage playerIdle, enemy1, enemy2, enemy3;

    public static void load() {
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.load("/sprite/fighter.png"));
        SpriteSheet enemySheet = new SpriteSheet(ImageLoader.load("/sprite/enemy.png"));
        SpriteSheet bulletSheet = new SpriteSheet(ImageLoader.load("/sprite/bullet.png"));
        SpriteSheet explosionSheet = new SpriteSheet(ImageLoader.load("/sprite/boom.png"));
        SpriteSheet enemySheet1 = new SpriteSheet(ImageLoader.load("/sprite/enemy1.png"));
        SpriteSheet enemySheet2 = new SpriteSheet(ImageLoader.load("/sprite/enemy2.png"));
        SpriteSheet enemyBulletSheet = new SpriteSheet(ImageLoader.load("/sprite/weapon/weapon.png"));
        SpriteSheet deathRay = new SpriteSheet(ImageLoader.load("/sprite/weapon/death-ray.png"));
        SpriteSheet headSheet = new SpriteSheet(ImageLoader.load("/sprite/123.png"));
        deathRayWep = new BufferedImage[3];
        for (int i = 0; i < deathRayWep.length; i++) {
            deathRayWep[i] = deathRay.crop(0, i * 39, 39, 39);
        }
        bulletHead = new BufferedImage[1];
        bulletHead[0] = headSheet.crop(0, 0, 412, 412);

        enemyBullet = new BufferedImage[1];
        enemyBullet[0] = enemyBulletSheet.crop(170 * 2, 0, 90, 144);
        enemy2 = enemySheet2.crop(0, 0, 1600, 1600);
        enemy3 = enemySheet1.crop(0, 0, 173, 291);
        enemy1 = enemySheet.crop(0, 0, 100, 100);
        loadPlayer(playerSheet);
        loadExplosion(explosionSheet);

        bullet = new BufferedImage[4];
        bullet[0] = bulletSheet.crop(0, 75 * 3, 75, 75);
        bullet[1] = bulletSheet.crop(75, 75 * 3, 75, 75);
        bullet[2] = bulletSheet.crop(75 * 2, 75 * 3, 75, 75);
        bullet[3] = bulletSheet.crop(75 * 3, 75 * 3, 75, 75);
    }

    private static void loadExplosion(SpriteSheet explosionSheet) {
        explode = new BufferedImage[15];
        explode[0] = explosionSheet.crop(0, 0, 96, 96);
        explode[1] = explosionSheet.crop(96, 0, 96, 96);
        explode[2] = explosionSheet.crop(96 * 2, 0, 96, 96);
        explode[3] = explosionSheet.crop(96 * 3, 0, 96, 96);
        explode[4] = explosionSheet.crop(0, 96, 96, 96);
        explode[5] = explosionSheet.crop(96, 96, 96, 96);
        explode[6] = explosionSheet.crop(96 * 2, 96, 96, 96);
        explode[7] = explosionSheet.crop(96 * 3, 96, 96, 96);
        explode[8] = explosionSheet.crop(0, 96 * 2, 96, 96);
        explode[9] = explosionSheet.crop(96, 96 * 2, 96, 96);
        explode[10] = explosionSheet.crop(96 * 2, 96 * 2, 96, 96);
        explode[11] = explosionSheet.crop(96 * 3, 96 * 2, 96, 96);
        explode[12] = explosionSheet.crop(0, 96 * 3, 96, 96);
        explode[13] = explosionSheet.crop(96, 96 * 3, 96, 96);
        explode[14] = explosionSheet.crop(96 * 2, 96 * 3, 96, 96);

    }

    private static void loadPlayer(SpriteSheet playerSheet) {
        playerLeft = new BufferedImage[3];
        playerLeft[0] = playerSheet.crop(0, 0, 64, 64);
        playerLeft[1] = playerSheet.crop(64, 0, 64, 64);
        playerLeft[2] = playerSheet.crop(64 * 2, 0, 64, 64);
        playerIdle = playerSheet.crop(64 * 3, 0, 64, 64);
        playerRight = new BufferedImage[3];
        playerRight[0] = playerSheet.crop(64 * 6, 0, 64, 64);
        playerRight[1] = playerSheet.crop(64 * 5, 0, 64, 64);
        playerRight[2] = playerSheet.crop(64 * 6, 0, 64, 64);

    }
}
