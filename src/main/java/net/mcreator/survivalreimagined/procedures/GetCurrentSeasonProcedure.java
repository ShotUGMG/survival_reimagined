package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GetCurrentSeasonProcedure {
	public static String execute(LevelAccessor world) {
		if (!world.isClientSide()) {
			if (world instanceof net.minecraft.world.level.Level level && sereneseasons.api.season.SeasonHelper.getSeasonState(level).getSubSeason().getSeason() == sereneseasons.api.season.Season.SPRING) {
				return "Spring";
			} else if (world instanceof net.minecraft.world.level.Level level && sereneseasons.api.season.SeasonHelper.getSeasonState(level).getSubSeason().getSeason() == sereneseasons.api.season.Season.SUMMER) {
				return "Summer";
			} else if (world instanceof net.minecraft.world.level.Level level && sereneseasons.api.season.SeasonHelper.getSeasonState(level).getSubSeason().getSeason() == sereneseasons.api.season.Season.AUTUMN) {
				return "Autumn";
			} else if (world instanceof net.minecraft.world.level.Level level && sereneseasons.api.season.SeasonHelper.getSeasonState(level).getSubSeason().getSeason() == sereneseasons.api.season.Season.WINTER) {
				return "Winter";
			}
		}
		return "Unknown";
	}
}