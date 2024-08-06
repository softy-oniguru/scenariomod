package net.gurudev.storytelling.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gurudev.storytelling.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityManager {
    public static EntityType<StorytellerEntity> STORYTELLER;

    public static void registerEntities() {
        STORYTELLER = Registry.register(
                Registries.ENTITY_TYPE, Identifier.of(Main.MOD_ID, "storyteller"),
                EntityType.Builder.create(StorytellerEntity::new, SpawnGroup.MISC)
                        .dimensions(0.6f, 1.8f).eyeHeight(1.62f)
                        .vehicleAttachment(.5f).build("storyteller")
        ); FabricDefaultAttributeRegistry.register(STORYTELLER, StorytellerEntity.createMobAttributes());
    }
}
