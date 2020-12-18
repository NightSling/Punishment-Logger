package net.crackpixel.daysling.listiners;

import me.leoko.advancedban.bungee.event.PunishmentEvent;
import me.leoko.advancedban.bungee.event.RevokePunishmentEvent;
import me.leoko.advancedban.utils.Punishment;
import net.crackpixel.daysling.webhook.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.awt.*;
import java.io.IOException;

public class PunishmentListeners implements Listener {

    @EventHandler
    public void onPunishment(PunishmentEvent e) throws IOException {
        Punishment punishment = e.getPunishment();
        String type = punishment.getType().getName();
        String playername = punishment.getName();
        String duration  = punishment.getDuration(true);
        String operator = punishment.getOperator();
        String reason = punishment.getReason();
        DiscordWebhook Webhookbuilder = new DiscordWebhook("https://");
        DiscordWebhook.EmbedObject object = new DiscordWebhook.EmbedObject();
        Webhookbuilder.addEmbed(
                      object.setTitle("Punishment Granted")
                            .setColor(Color.RED)
                            .addField("Punishment Type: ", type, true)
                            .addField("Player Name: ", playername, true )
                            .addField("Duration: ", duration, true )
                            .addField("Operator: ", operator, true)
                            .addField("Reason: ", reason, true)
                            .setFooter("Awesome Logger by dayslin#0651", "https://cdn.discordapp.com/avatars/459342334564237323/d1de39a00e3c0c483d33bfb5036232c7.webp")
                            .setAuthor("Punishment logger", "https://crackpixel-store.tebex.io", "https://cdn.discordapp.com/icons/736951354517356564/a_b13a87dea71fc853e1c2fb80effd4862.png" )

        );
        Webhookbuilder.addEmbed(object);
        Webhookbuilder.setUsername("Logger");
        Webhookbuilder.setAvatarUrl("https://cdn.discordapp.com/icons/736951354517356564/a_b13a87dea71fc853e1c2fb80effd4862.png");
        Webhookbuilder.execute();
    }
    @EventHandler
    public void onPunishmentRemove(RevokePunishmentEvent e) throws IOException {
        String type = e.getPunishment().getType().getName();
        String playername = e.getPunishment().getName();
        String Operator  = e.getPunishment().getOperator();
        String reason = e.getPunishment().getReason();
        DiscordWebhook Webhookbuilder = new DiscordWebhook("");
        DiscordWebhook.EmbedObject object = new DiscordWebhook.EmbedObject();
        Webhookbuilder.addEmbed(
                object.setTitle("Punishment Revoked")
                        .setColor(Color.GREEN)
                        .addField("Punishment Type: ", type, true)
                        .addField("Player Name: ", playername, true)
                        .addField("Operator: ", Operator, true)
                        .addField("Reason: ", reason, true)
                        .setFooter("Awesome Logger by dayslin#0651", "https://cdn.discordapp.com/avatars/459342334564237323/d1de39a00e3c0c483d33bfb5036232c7.webp")
                        .setAuthor("Punishment logger", "https://crackpixel-store.tebex.io", "https://cdn.discordapp.com/icons/736951354517356564/a_b13a87dea71fc853e1c2fb80effd4862.png" )
        );
        Webhookbuilder.addEmbed(object);
        Webhookbuilder.setUsername("Logger");
        Webhookbuilder.setAvatarUrl("https://cdn.discordapp.com/icons/736951354517356564/a_b13a87dea71fc853e1c2fb80effd4862.png");
        Webhookbuilder.execute();

    }
}
