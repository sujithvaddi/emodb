package com.bazaarvoice.emodb.sor.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public final class TableOptions {
    private final String _placement;
    private final List<FacadeOptions> _facades;

    TableOptions(@JsonProperty("placement") String placement, @JsonProperty("facades") List<FacadeOptions> facadeOptions) {
        _placement = checkNotNull(placement, "Table option is required: placement");
        _facades = Objects.firstNonNull(facadeOptions, Collections.<FacadeOptions>emptyList());
    }

    /**
     * Returns a placement string in the format "keyspace:column_family_prefix".
     */
    public String getPlacement() {
        return _placement;
    }

    /**
     * Returns facades list for this table.
     */
    public List<FacadeOptions> getFacades() {
        return _facades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TableOptions)) {
            return false;
        }
        TableOptions that = (TableOptions) o;
        return _placement.equals(that._placement) &&
                _facades.equals(that._facades);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_placement, _facades);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("placement", _placement)
                .toString();
    }
}
