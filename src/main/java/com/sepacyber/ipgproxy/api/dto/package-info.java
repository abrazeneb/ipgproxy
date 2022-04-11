/**
 * This is the place for the request and response for the primary or driving adapters.
 * <p>
 *The reason for the DTO's here is to avoid core components method input changes don't affect clients.
 * e.g Different adapters using the same contracts my want to use slightly different models and instead of this adapter
 * changing the models, it just maps dto's here to match the input of the core
 * </p>
 */
package com.sepacyber.ipgproxy.api.dto;