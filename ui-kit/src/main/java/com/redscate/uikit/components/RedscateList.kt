package com.redscate.uikit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class RedscateListItemData(
    val id: String,
    val title: String,
    val leadingValue: String? = null,
    val leadingLabel: String? = null,
    val primaryMetrics: List<RedscateCardMetric> = emptyList(),
    val trailingMetric: RedscateCardMetric? = null,
    val action: RedscateCardAction? = null,
    val tone: RedscateCardTone = RedscateCardTone.Neutral
)

@Composable
fun RedscateList(
    items: List<RedscateListItemData>,
    modifier: Modifier = Modifier,
    onItemClick: ((itemId: String) -> Unit)? = null,
    onActionClick: (itemId: String, actionId: String) -> Unit = { _, _ -> }
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items, key = { it.id }) { item ->
            RedscateListItem(
                item = item,
                modifier = if (onItemClick != null) {
                    Modifier.clickable { onItemClick(item.id) }
                } else {
                    Modifier
                },
                onActionClick = { actionId -> onActionClick(item.id, actionId) }
            )
        }
    }
}

@Composable
fun RedscateListItem(
    item: RedscateListItemData,
    modifier: Modifier = Modifier,
    onActionClick: (actionId: String) -> Unit = {}
) {
    Column(modifier = modifier.padding(horizontal = 2.dp)) {
        RedscateCard(
            config = RedscateCardConfig(
                title = item.title,
                leadingValue = item.leadingValue,
                leadingLabel = item.leadingLabel,
                headlineMetric = item.trailingMetric,
                detailMetrics = item.primaryMetrics,
                footerAction = item.action,
                tone = item.tone
            ),
            onActionClick = onActionClick
        )
    }
}
