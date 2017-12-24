package xbagon.timac;

import com.google.common.collect.ImmutableList;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.Collection;

public class SpecialPartMaterialType extends PartMaterialType {
    private final String[] neededTypes;

    public SpecialPartMaterialType(IToolPart part, String... statIDs) {
        super(part, statIDs);
        neededTypes = statIDs;
    }


    @Override
    public Collection<ITrait> getApplicableTraitsForMaterial(Material material) {
        if (!isValidMaterial(material)) {
            return ImmutableList.of();
        }

        ImmutableList.Builder<ITrait> traits = ImmutableList.builder();
        // traits of the types used
        for (String type : neededTypes) {
            traits.addAll(material.getAllTraitsForStats(type));
        }


        return traits.build();
    }
}
